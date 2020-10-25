package com.atguigu.springboot;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void testFindAll(){
        List<User> users = userService.findAll();
        System.out.println("users = " + users);

    }

}
