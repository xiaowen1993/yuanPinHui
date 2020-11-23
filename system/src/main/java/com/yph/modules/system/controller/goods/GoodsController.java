package com.yph.modules.system.controller.goods;


import com.yph.annotation.Pmap;
import com.yph.modules.system.service.GoodsService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author 
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/system/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goodsPage")
    public R goodsPage(@Pmap P p){

        return R.success();
    }

    @PostMapping("/goodsAdd")
    public R goodsAdd(@Pmap P p){

        return R.success();
    }

    @PostMapping("/goodsEdit")
    public R goodsEdit(@Pmap P p){

        return R.success();
    }

    @DeleteMapping("/goodsRemove")
    public R goodsRemove(){

        return R.success();
    }
}
