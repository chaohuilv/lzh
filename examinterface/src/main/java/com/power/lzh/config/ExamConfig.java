package com.power.lzh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "exam")
@Component
public class ExamConfig {

    private String appId;

    private String appKey;

    private String domainUrl;

    private String achievementCode;

    private String longinCode;

}
