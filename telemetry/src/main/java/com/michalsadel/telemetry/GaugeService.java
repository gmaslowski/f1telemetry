package com.michalsadel.telemetry;

import com.michalsadel.data.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.convert.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.*;
import java.util.concurrent.atomic.*;

@Service
class GaugeService {
    private static final Logger log = LoggerFactory.getLogger(GaugeService.class);
    private AtomicInteger indicator = new AtomicInteger(0);
    private static final int MAX_VALUE = 220;
    private static final int MIN_VALUE = 0;
    public static final int BUFFER_SIZE = 1237;
    private boolean increasing = true;

    private final GaugeSocketHandler gaugeSocketHandler;
    private final ConversionService conversionService;

    @Autowired
    public GaugeService(GaugeSocketHandler gaugeSocketHandler, ConversionService conversionService) {
        this.gaugeSocketHandler = gaugeSocketHandler;
        this.conversionService = conversionService;
    }

    void execute() {
        while (true) {
            final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("demo.f1t");
            byte[] buffer = new byte[GaugeService.BUFFER_SIZE];
            try {
                while (stream.read(buffer) != -1) {
                    final Telemetry telemetry = conversionService.convert(ByteBuffer.wrap(buffer), Telemetry.class);
                    gaugeSocketHandler.execute(telemetry);
                    Thread.sleep(18);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    //@Scheduled(fixedDelay = 10)
    void update() {
        int value = increasing ? indicator.incrementAndGet() : indicator.decrementAndGet();
        increasing = (value == MAX_VALUE) ? !increasing : (value == MIN_VALUE) ? !increasing : increasing;
        final Telemetry telemetry = new Telemetry();
        telemetry.setSpeed(value);
        gaugeSocketHandler.execute(telemetry);
    }
}
