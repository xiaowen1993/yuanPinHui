package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.SysRoleEntity;
import com.yph.modules.system.entity.SysRoleMenuEntity;
import com.yph.modules.system.service.SysAdminRoleService;
import com.yph.modules.system.service.SysRoleMenuService;
import com.yph.modules.system.service.SysRoleService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysAdminRoleService sysAdminRoleService;

    @Autowired
    SysRoleMenuService sysRoleMenuService;


    /**
     * 得到所有角色
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(){
        return R.success().data(sysRoleService.list());
    }


    /**
     * 添加一个角色
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@Pmap P p) throws Exception{
        SysRoleEntity sysRoleEntity=p.thisToEntity(SysRoleEntity.class);
        sysRoleEntity.setCreateTime(new Date());
        sysRoleService.save(sysRoleEntity);
        return R.success();
    }


    /**
     * 根据id删除角色
     * @param p
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R delete(@Pmap P p){
        sysRoleService.removeById(p.getInt("id"));
        return R.success();
    }


    /**
     * 根据id修改角色
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R update(@Pmap P p) throws Exception{
        SysRoleEntity sysRoleEntity=p.thisToEntity(SysRoleEntity.class);
        sysRoleEntity.setUpdateTime(new Date());
        sysRoleService.updateById(sysRoleEntity);
        return R.success();
    }


    /**
     * admin分配权限
     * @return
     */
    @RequestMapping(value = "/adminForRole",method = RequestMethod.POST)
    public R adminForRole(@Pmap P p){
        String[] ids = p.getStringArray("ids");

        return R.success();
    }




    /**
     * 角色分配权限
     * @param p
     * @return
     */
    @Transactional
    @RequestMapping(value = "/roleForMenu",method = RequestMethod.POST)
    public R roleForMenu(@Pmap P p){
        String[] menuIds = p.getStringArray("menuIds");
        if (menuIds.length==0){
            return R.error("至少选中一条");
        }

        UpdateWrapper<SysRoleMenuEntity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("role_id",p.getInt("roleId"));
        sysRoleMenuService.remove(updateWrapper);

        List<SysRoleMenuEntity> list=new ArrayList<>();
        for (String s:menuIds){
            SysRoleMenuEntity sysRoleMenuEntity=new SysRoleMenuEntity();
            sysRoleMenuEntity.setRoleId(p.getInt("roleId"));
            sysRoleMenuEntity.setMenuId(Integer.parseInt(s));
            list.add(sysRoleMenuEntity);
        }

        sysRoleMenuService.saveBatch(list);
        return R.success();
    }






}
