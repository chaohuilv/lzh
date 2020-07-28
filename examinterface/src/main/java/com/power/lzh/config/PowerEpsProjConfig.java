package com.power.lzh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "power")
@Component
public class PowerEpsProjConfig {
    private String epsProjId;
}
