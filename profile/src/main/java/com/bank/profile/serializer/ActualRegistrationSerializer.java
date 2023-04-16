package com.bank.profile.serializer;

import com.bank.profile.entity.ActualRegistration;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ActualRegistrationSerializer extends StdSerializer<ActualRegistration> {
    public ActualRegistrationSerializer() {
        this(null);
    }

    protected ActualRegistrationSerializer(Class<ActualRegistration> t) {
        super(t);
    }

    @Override
    public void serialize(ActualRegistration actualRegistration, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", String.valueOf(actualRegistration.getId()));
        jsonGenerator.writeStringField("country", actualRegistration.getCountry());
        jsonGenerator.writeStringField("region", actualRegistration.getRegion());
        jsonGenerator.writeStringField("city", actualRegistration.getCity());
        jsonGenerator.writeStringField("district", actualRegistration.getDistrict());
        jsonGenerator.writeStringField("locality", actualRegistration.getLocality());
        jsonGenerator.writeStringField("street", actualRegistration.getStreet());
        jsonGenerator.writeStringField("houseNumber", String.valueOf(actualRegistration.getHouseNumber()));
        jsonGenerator.writeStringField("houseBlock", String.valueOf(actualRegistration.getHouseBlock()));
        jsonGenerator.writeStringField("flatNumber", String.valueOf(actualRegistration.getFlatNumber()));
        jsonGenerator.writeStringField("index", String.valueOf(actualRegistration.getIndex()));

        jsonGenerator.writeEndObject();
    }


}
