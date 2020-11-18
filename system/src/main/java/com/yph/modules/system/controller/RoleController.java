package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Jurisdiction;
import com.yph.annotation.Pmap;
import com.yph.enun.AdminRoleEnum;
import com.yph.modules.system.entity.*;
import com.yph.modules.system.service.SysAdminRoleService;
import com.yph.modules.system.service.SysMenuService;
import com.yph.modules.system.service.SysRoleMenuService;
import com.yph.modules.system.service.SysRoleService;
import com.yph.param.RedisParamenter;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    SysMenuService sysMenuService;


    @Autowired
    RedisService redisService;

    @Autowired
    SysRoleMenuService sysRoleMenuService;
    

    /**
     * 得到所有角色
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R list(@Pmap P p){
        p.initPageArg();
        Page<SysRoleEntity> page = new Page<>(p.getInt("page"),p.getInt("limit"));
        return R.success().data(sysRoleService.page(page));
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
     * admin分配角色
     * @return
     */
    @RequestMapping(value = "/adminForRole",method = RequestMethod.POST)
    @Jurisdiction
    public R adminForRole(@Pmap P p){
        String[] ids = p.getStringArray("ids");
        List<SysAdminRoleEntity> list =new ArrayList<>();
        List<String> root=new ArrayList<>();
        AdminEntity adminEntity = redisService.get(p.getCookieValue(RedisParamenter.ADMIN_LOING_USER_REDIS_KEY), AdminEntity.class);
        for (String id : ids) {
            SysMenuEntity sysMenuEntity = sysMenuService.getOne(new QueryWrapper<SysMenuEntity>().eq("id", id));
            root.add(sysMenuEntity.getUri());
            SysAdminRoleEntity sysAdminRoleEntity=new SysAdminRoleEntity();
            sysAdminRoleEntity.setAdminId(adminEntity.getAdminId());
            sysAdminRoleEntity.setRoleId(Integer.parseInt(id));
            list.add(sysAdminRoleEntity);
        }
        redisService.set(AdminRoleEnum.ADMIN_ROLE_REDIS+adminEntity.getAdminName(),root);
        sysAdminRoleService.saveBatch(list);
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
        sysRoleMenuService.remove(new UpdateWrapper<SysRoleMenuEntity>().eq("role_id",p.getInt("roleId")));
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
