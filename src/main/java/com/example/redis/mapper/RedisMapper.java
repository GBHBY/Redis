package com.example.redis.mapper;

import com.example.redis.bean.RedisBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/21 23:45
 */
@Repository
public interface RedisMapper {
    List<RedisBean> listPC();
}
