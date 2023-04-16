package com.bank.profile.util;

import com.bank.profile.entity.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityJsonBeforeUpdateSaver {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static String entityJson;

    public static String getEntityJson() {
        return entityJson;
    }

    public static void saveEntityJsonBeforeUpdate(BaseEntity unupdatedEntity) throws JsonProcessingException {
        entityJson = objectMapper.writeValueAsString(unupdatedEntity);
    }
}
