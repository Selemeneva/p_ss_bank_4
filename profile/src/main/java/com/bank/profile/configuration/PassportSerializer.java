package com.bank.profile.configuration;

import com.bank.profile.entity.Passport;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class PassportSerializer extends StdSerializer<Passport> {
    public PassportSerializer() {
        this(null);
    }

    protected PassportSerializer(Class<Passport> t) {
        super(t);
    }

    @Override
    public void serialize(Passport passport, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", String.valueOf(passport.getId()));
        jsonGenerator.writeNumberField("series", passport.getSeries());
        jsonGenerator.writeNumberField("number", passport.getNumber());
        jsonGenerator.writeStringField("lastName", passport.getLastName());
        jsonGenerator.writeStringField("firstName", passport.getFirstName());
        jsonGenerator.writeStringField("middleName", passport.getMiddleName());
        jsonGenerator.writeStringField("gender", passport.getGender());
        jsonGenerator.writeStringField("birthDate", passport.getBirthDate().toString());
        jsonGenerator.writeStringField("birthPlace", passport.getBirthPlace());
        jsonGenerator.writeStringField("issuedBy", passport.getIssuedBy());
        jsonGenerator.writeStringField("dateOfIssue", passport.getDateOfIssue().toString());
        jsonGenerator.writeNumberField("divisionCode", passport.getDivisionCode());
        jsonGenerator.writeStringField("expirationDate", passport.getExpirationDate().toString());
        jsonGenerator.writeStringField("registrationId", passport.getRegistration().getId().toString());
        jsonGenerator.writeEndObject();
    }
}
