package com.kou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kou.domain.User;
import com.kou.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplateKou")
    private RedisTemplate<String ,Object> redisTemplateKou;

    @Autowired
    private RedisUtil redisUtil;


    @Test
    void contextLoads() {
        //使用redisTemplate
        //opsForValue 操作字符串，类似String
        //opsForList 操作list
        //opsForSet
        //opsForHash
        //opsForZSet
        //opsForGeo

        /*
        获取连接
         */
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        redisTemplateKou.opsForValue().set("mykey","kou");
        Object o  =redisTemplateKou.opsForValue().get("mykey");
        System.out.println(o);

    }

    @Test
    public void test() throws JsonProcessingException {
        //使用json传递对象
        User user=new User("kou",15);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplateKou.opsForValue().set("userKou",jsonUser);
        Object user1 = redisTemplateKou.opsForValue().get("userKou");
        System.out.println(user1);
    }

    @Test
    public void TestRedisUtil(){
        redisUtil.set("king","寇王军");
        System.out.println(redisUtil.get("king"));
    }
}
