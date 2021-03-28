package com.elliot.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.elliot.jpa.repository")
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
