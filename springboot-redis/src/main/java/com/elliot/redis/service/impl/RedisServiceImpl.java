package com.elliot.redis.service.impl;

import com.elliot.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: elliot
 * @Date: 2021/3/28
 */
@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void setKeyExpired(String key) {
	    redisTemplate.expire(key, 10, TimeUnit.MILLISECONDS);
	}

	@Override
	public void incrKey(String key) {
	    redisTemplate.opsForValue().increment(key);
	}

	@Override
	public void remove(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void add(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}
}
