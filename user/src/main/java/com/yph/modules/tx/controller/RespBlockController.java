package com.yph.modules.tx.controller;


import com.yph.annotation.Pmap;
import com.yph.modules.tx.entity.RespBlockEntity;
import com.yph.modules.tx.service.IRespBlockService;
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
@RequestMapping("/tx/respBlock")
public class RespBlockController {

    @Autowired
    IRespBlockService respBlockService;

    @GetMapping("/list")
    public R list(@Pmap P p){
        return R.success().data(respBlockService.list());
    }

    @DeleteMapping("/delete")
    public R delete(@Pmap P p){
        return R.success().data(respBlockService.removeById(p.getInt("id")));
    }


    @PostMapping("/update")
    public R update(@Pmap P p)throws Exception{
        return R.success().data(respBlockService.updateById(p.thisToEntity(RespBlockEntity.class)));
    }

    @PutMapping("/save")
    public R save(@Pmap P p)throws Exception{
        return R.success().data(respBlockService.save(p.thisToEntity(RespBlockEntity.class)));
    }

}
