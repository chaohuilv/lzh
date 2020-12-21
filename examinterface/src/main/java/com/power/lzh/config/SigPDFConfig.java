package com.power.lzh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "sigpdf")
@Component
public class SigPDFConfig {

    private String url;

    private String key;

    private String password;

    private String sessionUrl;
}
