package com.example.redis.controller;

import com.example.redis.bean.Pms;
import com.example.redis.dao.PmsDao;
import com.example.redis.service.RedisDataService;
import com.example.redis.ustil.GlobalLogger;
import io.lettuce.core.RedisConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/17 0:48
 */
@RestController
@RequestMapping("Test")
public class TestController {
    private static String PRODUCT_ID = "444";
    private static String PRODUCT_ID_STOCK = "100";
    @Autowired
    private RedisDataService redisDataService;
    @Autowired
    private PmsDao pmsDao;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redis;

    @GetMapping("get")
    public void get() {
        Pms pms = new Pms();
        pms.setId(14);
        System.out.println(redis.opsForHash().get("DEPT", "inspection"));
    }


    @GetMapping("buy")
    public int buy() {
        String value = UUID.randomUUID().toString();
        Boolean result = redis.opsForValue().setIfAbsent(PRODUCT_ID, value, 1, TimeUnit.SECONDS);
        try {
            if (!result) {
                return -1;
            }
            int stock = (int) redis.opsForValue().get(PRODUCT_ID_STOCK);
            if (stock > 0) {
                redis.opsForValue().set(PRODUCT_ID_STOCK, stock - 1);
                GlobalLogger.info("扣库存成功");
                return 1;
            } else {
                GlobalLogger.info("库存已空");
                return 2;
            }
        } catch (RedisConnectionException conn) {
            GlobalLogger.error("redis连接失败", conn);
            return 3;

        } catch (Exception e) {
            GlobalLogger.error("未知异常", e);
            return 4;

        } finally {
            if (value.equals(redis.opsForValue().get(PRODUCT_ID))) {
                redis.delete(PRODUCT_ID);
            }
        }


    }


}
