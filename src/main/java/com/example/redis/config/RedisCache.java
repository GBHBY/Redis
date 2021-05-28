package com.example.redis.config;

import org.apache.ibatis.cache.Cache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;


/**
 * @author gb
 * @version 1.0
 * description:
 * @date 2021/5/19 20:54
 */
public class RedisCache implements Cache {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final String id;
    /**
     * nameSpace
     **/
    private String oriId;

    private static RedisTemplate redisTemplate;

    static {
        redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
    }

    public RedisCache(String id) {
        this.oriId = id;
        this.id = DigestUtils.md5DigestAsHex(id.getBytes());
    }

    /**
     * 返回cache的唯一标识
     **/
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        logger.info("putObject : id:======" + oriId);
        logger.info("putObject : 加密后key:======" + renameKey(key.toString()));


        redisTemplate.opsForHash().put(id, renameKey(key.toString()), value);
    }

    @Override
    public Object getObject(Object key) {
        logger.info("getObject : id:======" + oriId);
        logger.info("putObject : 加密后key:======" + renameKey(key.toString()));
        return redisTemplate.opsForHash().get(id, renameKey(key.toString()));
    }

    @Override
    public Object removeObject(Object key) {
        logger.info("调用了remove");
        return null;
    }

    @Override
    public void clear() {
        logger.info("调用了clear");
        redisTemplate.delete(oriId);
    }

    /**
     * 用来计算缓存数量
     *
     * @return
     */
    @Override
    public int getSize() {
        logger.info("调用了getSize");
        return redisTemplate.opsForHash().size(id).intValue();
    }

    public String renameKey(String key){
        String[] split = key.split(":");
        return split[2];
    }


}
