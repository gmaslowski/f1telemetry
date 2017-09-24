package com.michalsadel.telemetry;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.web.socket.config.annotation.*;

@SpringBootApplication
@EnableWebSocket
@EnableScheduling
public class Application implements WebSocketConfigurer, ApplicationListener<ApplicationReadyEvent> {
    private final GaugeSocketHandler gaugeSocketHandler;
    private final GaugeService gaugeService;

    public Application(@Autowired GaugeSocketHandler gaugeSocketHandler, @Autowired GaugeService gaugeService) {
        this.gaugeSocketHandler = gaugeSocketHandler;
        this.gaugeService = gaugeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(gaugeSocketHandler, "/gauge").setAllowedOrigins("*");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        gaugeService.execute();
    }
}

