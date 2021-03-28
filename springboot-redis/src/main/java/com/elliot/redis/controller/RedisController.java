package com.elliot.redis.controller;

import com.elliot.redis.service.RedisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: elliot
 * @Date: 2021/3/28
 */
@RestController
@RequestMapping("/api")
public class RedisController {

	@Resource
	private RedisService redisService;

	@PostMapping("/add")
	public void add(@RequestParam String key, @RequestParam String value) {
		redisService.add(key, value);
	}
}
