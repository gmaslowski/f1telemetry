package com.michalsadel.telemetry.converter;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.michalsadel.data.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.convert.converter.*;
import org.springframework.stereotype.*;
import org.springframework.web.socket.*;

@Service
class TelemetryToTextMessageConverter implements Converter<Telemetry, TextMessage> {
    private final ObjectMapper objectMapper;

    public TelemetryToTextMessageConverter(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public TextMessage convert(Telemetry source) {
        try {
            return new TextMessage(objectMapper.writeValueAsString(source));
        } catch (JsonProcessingException e) {
            //this is stupid :D
            return new TextMessage("Error");
        }
    }
}
