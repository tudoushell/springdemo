package com.elliot.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @Author: elliot
 * @Date: 2021/3/28
 */
@Configuration
public class RedisConfig {

  @Resource
  private RedisConfigParams redisConfigParams;

  /**
   * 缓存使用redis
   *
   * @return
   */
  @Bean
  public CacheManager cacheManager() {
    RedisSerializer<String> redisSerializer = new StringRedisSerializer();
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    //解决查询缓存转换异常的问题
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    // 配置序列化（解决乱码的问题）
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(redisConfigParams.getCacheExpiredTime()))
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
            .disableCachingNullValues();
    RedisCacheManager cacheManager = RedisCacheManager.builder(getConnectionFactory())
            .cacheDefaults(config)
            .build();
    return cacheManager;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    //创建Redis缓存操作助手RedisTemplate对象
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(getConnectionFactory());
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    //RedisTemplate对象需要指明Key序列化方式，如果声明StringRedisTemplate对象则不需要
    template.setKeySerializer(stringRedisSerializer);
    // hash的key也采用String的序列化方式
    template.setHashKeySerializer(stringRedisSerializer);
    //以下代码为将RedisTemplate的Value序列化方式由JdkSerializationRedisSerializer
    //2.FastJson序列化方式
    FastJson2JsonRedisSerializer fastJson2JsonRedisSerializer = new FastJson2JsonRedisSerializer<Object>(Object.class);
    // value序列化方式采用fastson
    template.setValueSerializer(fastJson2JsonRedisSerializer);
    // hash的value序列化方式采用fastson
    template.setHashValueSerializer(fastJson2JsonRedisSerializer);
    //template.setEnableTransactionSupport(true);//是否启用事务
    template.afterPropertiesSet();
    return template;

  }

  @Bean
  public RedisConnectionFactory getConnectionFactory() {
    //单机模式
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    configuration.setHostName(redisConfigParams.getHost());
    configuration.setPort(redisConfigParams.getPort());
//    configuration.setPassword(RedisPassword.of(password));
    LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration, getPoolConfig());
    return factory;
  }

  /**
   * 获取缓存连接池
   *
   * @return
   */
  @Bean
  public LettucePoolingClientConfiguration getPoolConfig() {
    GenericObjectPoolConfig config = new GenericObjectPoolConfig();
    config.setMaxTotal(redisConfigParams.getMaxTotal());
    config.setMaxWaitMillis(redisConfigParams.getMaxWait());
    config.setMaxIdle(redisConfigParams.getMaxIdle());
    config.setMinIdle(redisConfigParams.getMinIdle());
    LettucePoolingClientConfiguration pool = LettucePoolingClientConfiguration.builder()
            .poolConfig(config)
            .commandTimeout(Duration.ofMillis(redisConfigParams.getTimeout()))
            .shutdownTimeout(Duration.ofMillis(redisConfigParams.getShutdown()))
            .build();
    return pool;
  }
}
