package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysConfigEntity;
import com.yph.modules.system.entity.SysDictEntity;
import com.yph.modules.system.service.SysDictService;
import com.yph.util.P;
import com.yph.util.R;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
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
@RequestMapping("/system/dic")
public class SysDIcController {

    @Autowired
    private SysDictService dictService;

    /**
     * 查询字典
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        p.initPageArg();
        Page<SysDictEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<SysDictEntity> pageObject = dictService.page(objectPage,new QueryWrapper<SysDictEntity>()
                .eq("name", p.getString("name"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }

    /**
     * 删除字典
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public R delete(@Pmap P p){
        if(dictService.removeById(p.getInt("dict_id"))) {
            return R.success("success");
        }else {
            return R.error("error");
        }
    }
    /**
     * 修改字典
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@Pmap P p) throws Exception {
        SysDictEntity sysDictEntity = p.thisToEntity(SysDictEntity.class);
        return R.success("success", dictService.updateById(sysDictEntity));
    }
    /**
     * 增加字典
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception {
        SysDictEntity sysDictEntity = p.thisToEntity(SysDictEntity.class);
        if (p.getInt("status").equals("on")){
            p.put("status",0);
        }else {
            p.put("status",1);
        }
        return R.success("success",dictService.save(sysDictEntity));
    }

    /**
     * 修改字典状态
     */
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public R updateStatus(@Pmap P p){
        UpdateWrapper<SysDictEntity> wrapper = new UpdateWrapper<>();
        wrapper.eq("status", "status");
        return R.success("success",dictService.update(wrapper));
    }

}
