package com.example.redis.test;

import com.alibaba.fastjson.JSONObject;
import com.example.redis.RedisApplication;
import com.example.redis.bean.Pms;
import com.example.redis.bean.PmsExample;
import com.example.redis.dao.PmsDao;
import com.example.redis.service.RedisDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static java.util.Locale.CHINESE;


/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/15 15:00
 */
@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private RedisDataService redisDataService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private PmsDao pmsDao;


    @Before
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        logger.info("redis init over");
    }


    @Test
    public void test1() {
        String a = "-184533780:3209450700:com.example.redis.mapper.RedisMapper.listPC:0:2147483647:select\n" +
                "            c.price,\n" +
                "            c.cname ,\n" +
                "            p.name pname\n" +
                "            from commodity c left join pms p on p.category = c.category:SqlSessionFactoryBean";
        String[] split = a.split(":");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }

    @Test
    public void test2() {
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    @Test
    public void testTime() throws ParseException {
        Pms pms = new Pms();
        pms.setOrg(434);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", CHINESE);
        String format1 = format.format(date);
        System.out.println(format1 + "------");
        pms.setTime(date);
        System.out.println(pms.getTime() + "========");
        PmsExample example = new PmsExample();
        PmsExample.Criteria criteria = example.createCriteria();

        pmsDao.updateByExampleSelective(pms, example);

    }


}
