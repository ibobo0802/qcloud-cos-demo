package com.idopy.qcloud.config;

import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class COSCredentialsConfigure {
    @Value("${cos.qcloud.secret.id}")
    private String accessKey;
    @Value("${cos.qcloud.secret.key}")
    private String secretKey;
    @Value("${cos.qcloud.region}")
    private String region;

    @Bean
    public COSCredentials getCOSCredentials() {
        // 1 初始化用户身份信息(secretId, secretKey)
        return new BasicCOSCredentials(accessKey, secretKey);
    }

    @Bean
    public ClientConfig getClientConfig() {
        return new ClientConfig(new Region(region));
    }
}
