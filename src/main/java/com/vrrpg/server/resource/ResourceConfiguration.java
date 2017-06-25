package com.vrrpg.server.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ResourceConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceConfiguration.class);

    private final ApplicationContext context;

    public ResourceConfiguration(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    @ConditionalOnMissingBean
    ResourceManager dummyResourceManager() {
        return path -> {
            LOGGER.trace("getResource - {}", path);
            return context.getResource("classpath:dummy.png");
        };
    }
}
