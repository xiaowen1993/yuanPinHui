package com.test;


import com.yph.AppUser;
import com.yph.modules.user.entity.UserEntity;
import com.yph.modules.user.service.impl.UserServiceImpl;
import com.yph.util.P;
import com.yph.util.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AppUser.class})// 指定启动类
public class TestUser {


    @Autowired
    UserServiceImpl userService;


    //测试用户注册
    @Test
    public void testUserRegister() throws Exception {
        for (int i = 0; i < 100; i++) {
            P p=new P();
            p.put("phone",28392233+i);
            p.put("password","123456");
            p.put("inviterId",24209+i);
            R r = userService.userRegister(p);
            System.out.println(r);
        }
    }


    //查询用户上级
    @Test
    public void testSelectUserBySuperior() throws Exception {
        P p=new P();
        p.put("userId",24234);
//        p.put("userRank",2);
        R r = userService.selectUserBySuperior(p);
        Object data = r.get("data");
        List<UserEntity> list= (List<UserEntity>) data;
        System.out.println(list);
    }


    //测试升级降级
    @Test
    public void testUserUpgrade(){
        userService.userUpgrade();
    }

}
