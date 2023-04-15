package com.bank.profile.configuration;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.entity.Passport;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AccountDetailsIdSerializer extends StdSerializer<AccountDetailsId> {
    public AccountDetailsIdSerializer() {
        this(null);
    }

    protected AccountDetailsIdSerializer(Class<AccountDetailsId> t) {
        super(t);
    }

    @Override
    public void serialize(AccountDetailsId accountDetailsId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", String.valueOf(accountDetailsId.getId()));
        jsonGenerator.writeStringField("accountId", String.valueOf(accountDetailsId.getAccountId()));
        jsonGenerator.writeStringField("profileId", String.valueOf(accountDetailsId.getOwner().getId()));
        jsonGenerator.writeEndObject();
    }
}
