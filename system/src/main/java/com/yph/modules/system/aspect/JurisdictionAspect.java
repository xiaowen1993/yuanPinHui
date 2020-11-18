package com.yph.modules.system.aspect;

import com.alibaba.spring.util.AnnotationUtils;
import com.yph.annotation.Jurisdiction;
import com.yph.annotation.Pmap;
import com.yph.enun.AdminRoleEnum;
import com.yph.enun.JurisdictionEnum;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.service.SysAdminRoleService;
import com.yph.modules.system.service.SysMenuService;
import com.yph.modules.system.service.SysRoleMenuService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author : LC
 * 2020-11-16 14:03
 */
@Component
@Aspect
public class JurisdictionAspect {

    @Autowired
    RedisService redisService;

    @Autowired
    SysAdminRoleService sysAdminRoleService;

    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @Autowired
    SysMenuService sysMenuService;


    @Around("@annotation(com.yph.annotation.Jurisdiction)")
    public Object getRole(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        P p = null;
        Method method = signature.getMethod();
        Jurisdiction jurisdiction=method.getAnnotation(Jurisdiction.class);
        for (int i = 0; i < method.getParameters().length; i++) {
            if (method.getParameters()[i].isAnnotationPresent(Pmap.class)) {
                p = (P) proceedingJoinPoint.getArgs()[i];
            }
        }
        if (p==null){
            return R.error("p为空");
        }
        if (p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY) == null) {
            return R.error("cookie为空");
        }
        Map<ElementType, List<RequestMapping>> annotations = AnnotationUtils.findAnnotations(method, RequestMapping.class);
        if (annotations == null) {
            return R.error("缺少必要信息");
        }
        String uri = getUri(annotations);
        System.out.println(uri);
        AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);

        if (jurisdiction.jurisdictionNumber().getCont().equals(JurisdictionEnum.JURISDICTION_ADMIN.getCont())){
            if (adminEntity.getAdminLevel().equals(JurisdictionEnum.JURISDICTION_ADMIN.getCode()+"")){
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            }
        }

        List list = redisService.get(AdminRoleEnum.ADMIN_ROLE_REDIS + adminEntity.getAdminName(), List.class);
        for (Object o : list) {
            if (o.toString().equals(uri)){
                return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            }
        }
        return R.error("无权限");
    }



    public String getUri(Map<ElementType, List<RequestMapping>> annotations){
       String uri="";
        List<RequestMapping> requestMappings = annotations.get(ElementType.TYPE);
        for (RequestMapping requestMapping : requestMappings) {
            String[] path = requestMapping.path();
            for (String s : path) {
                uri+=s;
            }
        }
        List<RequestMapping> requestMappings1 = annotations.get(ElementType.METHOD);
        for (RequestMapping requestMapping : requestMappings1) {
            String[] path = requestMapping.path();
            for (String s : path) {
                uri+=s;
            }
        }

        return uri;
    }

}
