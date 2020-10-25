package com.atguigu.service.lmpl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS,
                    isolation = Isolation.REPEATABLE_READ,
                    rollbackFor = Exception.class)


    public List<User> findAll() {
        List<User> users = (List<User>) redisTemplate.boundValueOps("userKey").get();
        if (users == null){//缓存没有
            users = userMapper.selectAll();
            System.out.println("从数据库users = " + users);
            redisTemplate.boundValueOps("userKey").set(users);
        }else {//缓存中有
            System.out.println("从缓存中users = " + users);
        }

        return users;
    }
}
