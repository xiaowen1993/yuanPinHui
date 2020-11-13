package com.yph.modules.system.controller;


import com.yph.annotation.Pmap;
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
public class DIcController {

    @Autowired
    private SysDictService dictService;

    /**
     * 查询字典
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        return R.success("success",dictService.list());
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
        return R.success("success",dictService.updateById(sysDictEntity));
    }
    /**
     * 增加字典
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception {
        SysDictEntity sysDictEntity = p.thisToEntity(SysDictEntity.class);
        return R.success("success",dictService.save(sysDictEntity));
    }

}
