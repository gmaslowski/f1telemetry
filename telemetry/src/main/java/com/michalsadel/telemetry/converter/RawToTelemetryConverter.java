package com.michalsadel.telemetry.converter;

import com.michalsadel.data.*;
import org.springframework.core.convert.converter.*;
import org.springframework.stereotype.*;

import java.nio.*;

@Service
public class RawToTelemetryConverter implements Converter<ByteBuffer, Telemetry> {
    @Override
    public Telemetry convert(ByteBuffer source) {
        source.order(ByteOrder.LITTLE_ENDIAN);
        Telemetry result = new Telemetry();
        result.setTime(source.getFloat());
        result.setSpeed(source.getFloat(28) * 3.6f);
        result.setRevs(source.getFloat(148));
        result.setGear(Float.valueOf(source.getFloat(132) - 1).byteValue());
        result.setFuelInTank(source.getFloat(180));
        result.setFuelCapacity(source.getFloat(184));

        result.setWheelTemperature(new Wheel((short) (source.get(304) & 0xff), (short) (source.get(305) & 0xff), (short) (source.get(306) & 0xff), (short) (source.get(307) & 0xff)));
        result.setWheelWear(new Wheel((short) (source.get(308) & 0xff), (short) (source.get(309) & 0xff), (short) (source.get(310) & 0xff), (short) (source.get(311) & 0xff)));
        return result;
    }
}
