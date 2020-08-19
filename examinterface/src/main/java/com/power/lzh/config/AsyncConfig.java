package com.power.lzh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Autowired
    private TaskConfig taskConfig;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(taskConfig.getCorePoolSize());
        executor.setMaxPoolSize(taskConfig.getMaxPoolSize());
        executor.setQueueCapacity(taskConfig.getQueueCapacity());
        executor.initialize();
        return executor;
    }
}
