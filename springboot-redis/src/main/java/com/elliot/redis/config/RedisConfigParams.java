package com.elliot.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: elliot
 * @Date: 2021/3/28
 */
@Component
public class RedisConfigParams {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private Integer port;

	@Value("${spring.redis.lettuce.pool.max-active}")
	private Integer maxTotal;

	@Value("${spring.redis.lettuce.pool.max-wait}")
	private Integer maxWait;

	@Value("${spring.redis.lettuce.pool.max-idle}")
	private Integer maxIdle;

	@Value("${spring.redis.lettuce.pool.min-idle}")
	private Integer minIdle;

	@Value("${spring.redis.lettuce.shutdown-timeout}")
	private Integer shutdown;

	@Value("${spring.redis.timeout}")
	private Integer timeout;

	@Value("${spring.redis.cache.time-to-live}")
	private Long cacheExpiredTime;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}

	public Integer getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(Integer maxWait) {
		this.maxWait = maxWait;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getShutdown() {
		return shutdown;
	}

	public void setShutdown(Integer shutdown) {
		this.shutdown = shutdown;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Long getCacheExpiredTime() {
		return cacheExpiredTime;
	}

	public void setCacheExpiredTime(Long cacheExpiredTime) {
		this.cacheExpiredTime = cacheExpiredTime;
	}
}
