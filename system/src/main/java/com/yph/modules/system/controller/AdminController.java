package com.yph.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yph.annotation.Pmap;
import com.yph.modules.system.entity.AdminEntity;
import com.yph.modules.system.service.AdminService;
import com.yph.redis.service.RedisService;
import com.yph.util.P;
import com.yph.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LC
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    RedisService redisService;

    /**
     * 登录
     * @param p
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public R login(@Pmap P p){
        String adminName = p.getString("adminName");
        String adminPassword = p.getString("adminPassword");
        //判断账号是否存在
        AdminEntity AdminEntityOne = adminService.getOne(new QueryWrapper<AdminEntity>().eq("admin_name", adminName));
        if(AdminEntityOne!=null){
            if(AdminEntityOne.getAdminPassword().equals(adminPassword)) {
                //判断当前账号是否可用
                if(AdminEntityOne.getActivation().equals(1)){
                    //生成uuid
                    String id = AdminEntityOne.getAdminId()+AdminEntityOne.getAdminName();
                    //将对象放入redis
                    redisService.set(id,AdminEntityOne);
                    return R.success("登录成功").data(id);
                }else {
                    return R.success("当前账号不可使用，请前往激活");
                }
            }else {
                return R.success("密码错误，请重新输入");
            }
        }
        //判断当前账号和密码是否正确
        return R.success("当前账号不存在，请重新输入");
    }


    /**
     * 注册
     * @param p
     * @return
     */
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public R registered(@Pmap P p) throws Exception {
        AdminEntity adminEntity = p.thisToEntity(AdminEntity.class);
        if(adminEntity!=null){
            AdminEntity AdminEntityOne = adminService.getOne(new QueryWrapper<AdminEntity>().eq("admin_name", adminEntity.getAdminName()));
            if(AdminEntityOne!=null){
                return R.success("当前账号已存在，请重新输入");
            }
        }
        adminService.save(adminEntity);
        return R.success();
    }


    /**
     * 查询集合
     * @param p
     * @return
     */
    @RequestMapping(value = "/adminPage",method = RequestMethod.GET)
    public R adminPage(@Pmap P p) throws Exception {
        p.initPageArg();
        Page<AdminEntity> objectPage = new Page<>(p.getInt("page"),p.getInt("limit"));
        p.removeByKey(p);
        Page<AdminEntity> pageObject = adminService.page(objectPage,new QueryWrapper<AdminEntity>()
                .eq("admin_name", p.getString("adminName"))
                .eq("admin_nikename", p.getString("adminNikename"))
                .eq("activation", p.getString("activation"))
        );
        return R.success("success",pageObject.getRecords()).set("count",pageObject.getTotal());
    }


    /**
     * 修改
     * @param p
     * @return
     */
    @RequestMapping(value = "/adminEdit",method = RequestMethod.POST)
    public R adminEdit(@Pmap P p) throws Exception {
        AdminEntity adminEntity = p.thisToEntity(AdminEntity.class);
        adminService.update(adminEntity,new UpdateWrapper<AdminEntity>().eq("admin_id",adminEntity.getAdminId()));
        return R.success();
    }

    /**
     * 删除
     * @param p
     * @return
     */
    @RequestMapping(value = "/adminRemove",method = RequestMethod.POST)
    public R adminRemove(@Pmap P p) throws Exception {
        adminService.removeById(p.getInt("admin_id"));
        return R.success();
    }

}
