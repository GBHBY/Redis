package com.example.redis.service.impl;

import com.example.redis.bean.Commodity;
import com.example.redis.bean.CommodityExample;
import com.example.redis.dao.CommodityDao;
import com.example.redis.mapper.RedisMapper;
import com.example.redis.service.RedisDataService;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/22 0:08
 */
@Service
public class RedisDataServiceImpl implements RedisDataService {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private RedisMapper redisMapper;
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void listPC() {
        redisMapper.listPC();
    }

    @Override
    public List<Commodity> listAll() {
        PageHelper.startPage(2,10);
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        return commodityDao.selectByExample(commodityExample);
    }


}
