package com.yph.modules.system.controller.dept;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.entity.SysDeptEntity;
import com.yph.modules.system.service.SysDeptService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController {

    @Autowired
    RedisService redisService;
    
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 增加
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptAdd",method = RequestMethod.POST)
    public R sysDeptAdd(@Pmap P p) throws Exception {
        SysDeptEntity sysDeptEntity = p.thisToEntity(SysDeptEntity.class);
        if(sysDeptEntity!=null){
            AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
            sysDeptEntity.setCreateUser(adminEntity.getAdminName());
            sysDeptService.save(sysDeptEntity);
        }
        return R.success();
    }

    /**
     * 查询集合
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptPage",method = RequestMethod.GET)
    public R sysDeptPage(@Pmap P p) throws Exception {
        p.initPageArg();
        Page<SysDeptEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysDeptEntity> pageObject = sysDeptService.page(objectPage,new QueryWrapper<SysDeptEntity>()
                .eq(!StringUtils.isNullOrEmpty(p.getString("simpleName")),"simple_name", p.getString("simpleName"))
                .eq(!StringUtils.isNullOrEmpty(p.getString("fullName")),"full_name", p.getString("fullName"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }

    /**
     * 查询树形结构数据
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptTree",method = RequestMethod.GET)
    public R sysDeptTree(@Pmap P p) throws Exception {
        return sysDeptService.sysDeptTree(p);
    }


    /**
     * 修改
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptEdit",method = RequestMethod.POST)
    public R sysDeptEdit(@Pmap P p) throws Exception {
        SysDeptEntity sysDeptEntity = p.thisToEntity(SysDeptEntity.class);
        AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
        sysDeptEntity.setUpdateUser(adminEntity.getAdminName());
        sysDeptService.update(sysDeptEntity,new UpdateWrapper<SysDeptEntity>().eq("dept_id",sysDeptEntity.getDeptId()));
        return R.success();
    }

    /**
     * 删除
     * @param p
     * @return
     */
    @RequestMapping(value = "/sysDeptRemove",method = RequestMethod.DELETE)
    public R sysDeptRemove(@Pmap P p) throws Exception {
        sysDeptService.removeById(p.getInt("deptId"));
        return R.success();
    }

}
