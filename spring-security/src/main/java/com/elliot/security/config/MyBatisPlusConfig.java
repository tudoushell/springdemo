package com.elliot.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: elliot
 * @Date: 2021/4/14
 */
@Configuration
@MapperScan("com.elliot.security.mapper")
public class MyBatisPlusConfig {
}
