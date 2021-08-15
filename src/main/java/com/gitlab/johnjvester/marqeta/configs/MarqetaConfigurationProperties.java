package com.gitlab.johnjvester.marqeta.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration("marqetaConfigurationProperties")
@ConfigurationProperties("marqeta")
public class MarqetaConfigurationProperties {
    private String applicationToken;
    private String adminAccessToken;
    private String hostname;
    private boolean secure;
    private String baseUri;
}
