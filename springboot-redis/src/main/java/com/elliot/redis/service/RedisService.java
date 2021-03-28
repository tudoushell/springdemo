package com.elliot.redis.service;

/**
 * @Author: elliot
 * @Date: 2021/3/28
 */
public interface RedisService {

    /**
     * set key expired time 
     *
     * @param key
     */
    void setKeyExpired(String key);

    /**
     * increase key by 1
     *
     * @param key
     */
    void incrKey(String key);

    /**
     * remove key
     *
     * @param key
     */
    void remove(String key);

    /**
     * 添加
     *
     * @param key
     * @param value
     */
    void add(String key, String value);
}
