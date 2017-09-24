package com.michalsadel.telemetry;

import com.michalsadel.data.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.convert.*;
import org.springframework.stereotype.*;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.*;

import java.io.*;
import java.util.*;

@Component
class GaugeSocketHandler extends TextWebSocketHandler {
    private static final Logger log = LoggerFactory.getLogger(GaugeSocketHandler.class);
    private final Object padlock = new Object();
    private Collection<WebSocketSession> sessions = new ArrayList<>();
    private final ConversionService conversionService;

    public GaugeSocketHandler(@Autowired ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        synchronized (padlock) {
            sessions.add(session);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        synchronized (padlock) {
            sessions.remove(session);
        }
    }

    void execute(Telemetry telemetry) {
        final TextMessage textMessage = conversionService.convert(telemetry, TextMessage.class);
        synchronized (padlock) {
            sessions.stream().filter(x -> x.isOpen()).forEach(x -> {
                try {
                    x.sendMessage(textMessage);
                } catch (IOException e) {
                    log.error("Send impossible, client no longer want us :)");
                }
            });
        }
    }
}
