package com.xxx.sprngdateredis;

import com.xxx.sprngdateredis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class RedisStringTests {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void testString() {
        // 写入一条String数据
        redisTemplate.opsForValue().set("name2", "虎哥");
        // 获取string数据
        Object name = redisTemplate.opsForValue().get("name2");
        System.out.println("name = " + name);
    }



    @Test
    void testUser() {

        // 写入一条String数据
        redisTemplate.opsForValue().set("user:100", new User("张三",18));
        // 获取string数据
        User user = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println("user = " + user);
    }

    @Test
    void testHash() {
        redisTemplate.opsForHash().put("user:400", "name", "虎哥");
        redisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);
    }
}