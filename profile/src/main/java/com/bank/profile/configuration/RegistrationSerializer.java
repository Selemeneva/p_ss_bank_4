package com.bank.profile.configuration;

import com.bank.profile.entity.Profile;
import com.bank.profile.entity.Registration;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
public class RegistrationSerializer extends StdSerializer<Registration> {

    public RegistrationSerializer() {
        this(null);
    }

    protected RegistrationSerializer(Class<Registration> t) {
        super(t);
    }

    @Override
    public void serialize(Registration registration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeStartObject();
//
//        jsonGenerator.writeStringField("id", String.valueOf(registration.getId()));
//        jsonGenerator.writeStringField("region", registration.getRegion());
//        jsonGenerator.writeStringField("city", registration.getCity());
//        jsonGenerator.writeStringField("district", registration.getDistrict());
//        jsonGenerator.writeStringField("inn", String.valueOf(profile.getInn()));
//        jsonGenerator.writeStringField("snils", String.valueOf(profile.getSnils()));
//        jsonGenerator.writeStringField("passportId", String.valueOf(profile.getPassport().getId()));
//        jsonGenerator.writeStringField("actualRegistrationId", String.valueOf(profile.getActualRegistration().getId()));
//
//        jsonGenerator.writeEndObject();
    }
}
