package com.yph.modules.tx.controller;


import com.yph.annotation.Pmap;
import com.yph.modules.tx.entity.RespTxEntity;
import com.yph.modules.tx.service.IRespTxService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/tx/respTx")
public class RespTxController {

    @Autowired
    IRespTxService respTxService;

    @GetMapping("/list")
    public R list(@Pmap P p){
        return R.success().data(respTxService.list());
    }

    @DeleteMapping("/delete")
    public R delete(@Pmap P p){
        return R.success().data(respTxService.removeById(p.getInt("id")));
    }


    @PostMapping("/update")
    public R update(@Pmap P p)throws Exception{
        return R.success().data(respTxService.updateById(p.thisToEntity(RespTxEntity.class)));
    }

    @PutMapping("/save")
    public R save(@Pmap P p)throws Exception{
        return R.success().data(respTxService.save(p.thisToEntity(RespTxEntity.class)));
    }

}
