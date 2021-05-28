package com.example.redis.controller;

import com.example.redis.bean.Pms;
import com.example.redis.bean.PmsExample;
import com.example.redis.dao.PmsDao;
import com.example.redis.service.RedisDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/17 0:48
 */
@RestController
@RequestMapping("Test")
public class TestController {
    @Autowired
    private RedisDataService redisDataService;
    @Autowired
    private PmsDao pmsDao;

    @GetMapping("testRedis")
    public void testRedis() {
        redisDataService.listPC();
    }

    @GetMapping("time")
    public List<Pms> testTime() {

        PmsExample example = new PmsExample();
        PmsExample.Criteria criteria = example.createCriteria();
        return pmsDao.selectByExample(example);

    }


}
