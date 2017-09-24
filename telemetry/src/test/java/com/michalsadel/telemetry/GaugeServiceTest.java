package com.michalsadel.telemetry;

import com.michalsadel.data.*;
import com.michalsadel.telemetry.converter.*;
import org.junit.*;
import org.slf4j.*;

import java.io.*;
import java.nio.*;

public class GaugeServiceTest {
    private static final Logger log = LoggerFactory.getLogger(GaugeServiceTest.class);

    @Test
    public void testProtoclBuffer() throws IOException {
        RawToTelemetryConverter converter = new RawToTelemetryConverter();
        final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("demo.f1t");
        byte[] buffer = new byte[GaugeService.BUFFER_SIZE];
        int index = 0;
        while (stream.read(buffer) != -1) {
            final Telemetry convert = converter.convert(ByteBuffer.wrap(buffer));
            log.info("{}/{}", convert.getTime(), convert.getSpeed());
        }
    }
}