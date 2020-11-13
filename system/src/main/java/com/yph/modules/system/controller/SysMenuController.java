package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysMenuEntity;
import com.yph.modules.system.service.SysMenuService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author  LC
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {


    @Autowired
    SysMenuService menuService;


    /**
     * 得到tree结构数据
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R menuListAll(){
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",0);
        List<SysMenuEntity> list = menuService.list(queryWrapper);

        if (list.size()==0){
            return R.success().data(list);
        }

        for (SysMenuEntity s: list) {
            s.setChildren(getChildren(s.getId()));
        }
        return R.success().data(list);
    }


    /**
     * 递归tree
     * @param id
     * @return
     */
    public List<SysMenuEntity> getChildren(Integer id) {
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",id);
        List<SysMenuEntity> list = menuService.list(queryWrapper);
        if (list.size()==0){
            return list;
        }
        for (SysMenuEntity menu : list) {
            menu.setChildren(getChildren(menu.getId()));
        }
        return list;
    }

    /**
     * 新增数据
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception{
        SysMenuEntity sysMenuEntity = p.thisToEntity(SysMenuEntity.class);
        menuService.save(sysMenuEntity);
        return R.success();
    }

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/removeById",method = RequestMethod.GET)
    public R removeById(Integer id){
        menuService.removeById(id);
        return R.success();
    }


    /**
     * 根据id进行修改
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public boolean update(@Pmap P p) throws Exception{
        SysMenuEntity sysMenuEntity = p.thisToEntity(SysMenuEntity.class);
        return menuService.updateById(sysMenuEntity);
    }



}
