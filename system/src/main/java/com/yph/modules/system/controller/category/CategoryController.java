package com.yph.modules.system.controller.category;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.CategoryEntity;
import com.yph.modules.system.service.CategoryService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询集合
     * @param p
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p) throws Exception {
        p.initPageArg();
        Page<CategoryEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<CategoryEntity> pageObject = categoryService.page(objectPage,new QueryWrapper<CategoryEntity>()
                .eq("category_name", p.getString("categoryName"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }
    /**
     * 查询父类目
     */
    @RequestMapping(value = "/getCategoryPid",method = RequestMethod.GET)
    public R getCategoryPid(@Pmap P p){
        List<CategoryEntity> categoryEntityList = categoryService.list(new QueryWrapper<CategoryEntity>().eq("pid", "0"));
        return R.success("success",categoryEntityList);
    }

    /**
     * 根据父类目查询子类目
     */
    @RequestMapping(value = "/getCategoryListByPid",method = RequestMethod.GET)
    public R getCategoryListByPid(@Pmap P p){
        List<CategoryEntity> categoryEntities = categoryService.list(new QueryWrapper<CategoryEntity>().eq("pid", p.getInt("categoryId")));
        return R.success("success",categoryEntities);
    }

    /**
     * 增加
     * @param p
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception {
        CategoryEntity categoryEntity = p.thisToEntity(CategoryEntity.class);
        categoryEntity.setAddTime(new Date());
        categoryEntity.setUpdateTime(new Date());
        return R.success("success", categoryService.save(categoryEntity));
    }

    /**
     * 图片上传
     */

    /**
     * 修改
     * @param p
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public R edit(@Pmap P p) throws Exception {
        CategoryEntity categoryEntity = p.thisToEntity(CategoryEntity.class);
        return R.success("success", categoryService.updateById(categoryEntity));
    }

    /**
     * 删除
     * @param p
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public R del(@Pmap P p) throws Exception {
        return R.success("success", categoryService.removeById(p.getInt("category_id")));
    }

}
