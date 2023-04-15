package com.bank.profile.util;

import com.bank.profile.entity.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Updater {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static String entityJson;

    public static String getEntityJson() {
        return entityJson;
    }

    public static void setEntityJson(String entityJson) {
        Updater.entityJson = entityJson;
    }

    public static void updateInformationAboutCreating(BaseEntity entity, BaseEntity unupdatedEntity) throws JsonProcessingException {
        entity.setCreatedBy(unupdatedEntity.getCreatedBy());
        entity.setCreatedAt(unupdatedEntity.getCreatedAt());
        entityJson = objectMapper.writeValueAsString(unupdatedEntity);
    }
}
