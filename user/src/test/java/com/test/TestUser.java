package com.test;


import com.yph.AppUser;
import com.yph.modules.user.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AppUser.class})// 指定启动类
public class TestUser {


    @Autowired
    UserServiceImpl userService;

    @Test
    public void testUserUpgrade(){
        userService.userUpgrade();
    }

}
