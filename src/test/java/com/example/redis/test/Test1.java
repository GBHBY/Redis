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


}
