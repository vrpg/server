package com.vrrpg.server.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
class WebSocketConfig implements WebSocketConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        LOGGER.trace("registerWebSocketHandlers - {}", registry);
        registry.addHandler(socketHandler(), "/test").setAllowedOrigins("*");
    }

    @Bean
    public SocketHandler socketHandler() {
        LOGGER.trace("socketHandler");
        return new SocketHandler();
    }
}
