package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysConfigEntity;
import com.yph.modules.system.entity.SysDeptEntity;
import com.yph.modules.system.entity.SysDictEntity;
import com.yph.modules.system.service.SysConfigService;
import com.yph.modules.system.service.SysDictService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *字典
 * @author liu
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 查询系统配置
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        p.initPageArg();
        Page<SysConfigEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysConfigEntity> pageObject = sysConfigService.page(objectPage,new QueryWrapper<SysConfigEntity>()
                .eq("name", p.getString("name"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }

    /**
     * 删除系统配置
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public R delete(@Pmap P p){
        if(sysConfigService.removeById(p.getInt("id"))) {
            return R.success("success");
        }else {
            return R.error("error");
        }
    }
    /**
     * 修改系统配置
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@Pmap P p) throws Exception {
        SysConfigEntity sysConfigEntity = p.thisToEntity(SysConfigEntity.class);
        return R.success("success",sysConfigService.updateById(sysConfigEntity));
    }
    /**
     * 增加系统配置
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception {
        SysConfigEntity sysConfigEntity = p.thisToEntity(SysConfigEntity.class);
        return R.success("success",sysConfigService.save(sysConfigEntity));
    }


}
