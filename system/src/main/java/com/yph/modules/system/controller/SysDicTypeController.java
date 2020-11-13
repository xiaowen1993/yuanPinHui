package com.yph.modules.system.controller;


import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysDictEntity;
import com.yph.modules.system.entity.SysDictTypeEntity;
import com.yph.modules.system.service.SysDictService;
import com.yph.modules.system.service.SysDictTypeService;
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

    /**
     * 查询字典类型
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        return R.success("success",dictTypeService.list());
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
        return R.success("success",dictTypeService.save(sysDictTypeEntity));
    }

}
