package com.yph.modules.system.controller.dic;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.entity.SysDictTypeEntity;
import com.yph.modules.system.service.SysDictTypeService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *字典类型
 * @author liu
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/dicType")
public class SysDicTypeController {

    @Autowired
    private SysDictTypeService dictTypeService;


    @Autowired
    RedisService redisService;
    /**
     * 查询字典类型
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        p.initPageArg();
        Page<SysDictTypeEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysDictTypeEntity> pageObject = dictTypeService.page(objectPage,new QueryWrapper<SysDictTypeEntity>()
                .eq(!StringUtils.isNullOrEmpty(p.getString("name")),"name", p.getString("name"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }

    /**
     * 删除字典类型
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public R delete(@Pmap P p){
        if(dictTypeService.removeById(p.getInt("id"))) {
            return R.success("success");
        }else {
            return R.error("error");
        }
    }
    /**
     * 修改字典类型
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@Pmap P p) throws Exception {
        SysDictTypeEntity sysDictTypeEntity = p.thisToEntity(SysDictTypeEntity.class);
        return R.success("success",dictTypeService.updateById(sysDictTypeEntity));
    }
    /**
     * 增加字典类型
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception {
        SysDictTypeEntity sysDictTypeEntity = p.thisToEntity(SysDictTypeEntity.class);
        AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
        sysDictTypeEntity.setCreateUser(adminEntity.getAdminId());
        sysDictTypeEntity.setUpdateUser(adminEntity.getAdminId());
        if (p.getInt("status").equals("on")){
            p.put("status",0);
        }else {
            p.put("status",1);
        }
        return R.success("success",dictTypeService.save(sysDictTypeEntity));
    }

}
