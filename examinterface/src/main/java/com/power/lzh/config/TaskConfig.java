package com.power.lzh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "task")
@Component
public class TaskConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;
}
