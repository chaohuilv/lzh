package com.power.lzh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "project")
@Component
public class ProjectConfig {

    private String url; //项目地址

    private String ftpUrl; //ftp地址

}
