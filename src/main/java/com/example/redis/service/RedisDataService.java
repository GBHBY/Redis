package com.example.redis.service;

import com.example.redis.bean.Commodity;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/22 0:07
 */

public interface RedisDataService {
    void listPC();

    List<Commodity> listAll();
}
