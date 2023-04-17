package com.bank.antifraud.listener;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.entity.SuspiciousTransfer;
import com.bank.antifraud.repository.AuditRepository;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferListener {

    @Autowired ApplicationContext applicationContext;
    AuditRepository auditRepository;
    final Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();;


    private void init() {
        if (auditRepository == null) {
            this.auditRepository = applicationContext.getBean(AuditRepository.class);
        }
    }

    /**

     Метод, вызываемый автоматически при сохранении (persist) сущности в базу данных.
     Инициализирует контекст приложения, создает объект Audit, заполняет его данными и сохраняет в репозиторий Audit.
     @param entity Сущность, которая будет сохранена в базу данных.
     */
    @PrePersist
    public void prePersist(Object entity) {
        init();
        Audit audit = Audit.builder()
                .entityType(entity.getClass().getSimpleName())
                .operationType("CREATE")
                .createdBy("me")
//                .createdBy(SecurityContextHolder.getContext().getAuthentication().getName())
                .createdAt(LocalDateTime.now())
                .entityJson(gson.toJson(entity))
                .build();
        auditRepository.save(audit);
    }

    /**
     Вызывается перед обновлением сущности в базе данных и создает новую запись аудита.
     @param entity обновляемая сущность
     */
    @PreUpdate
    public void preUpdate(Object entity) {
        init();
        String type = entity.getClass().getSimpleName();
//        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal = "me";
        Audit audit = Audit.builder()
                .entityType(type)
                .operationType("UPDATE")
                .modifiedBy(principal)
                .modifiedAt(LocalDateTime.now())
                .entityJson(gson.toJson(entity))
                .newEntityJson(gson.toJson(List.of(
                        type, "PRE-UPDATE", principal, ((SuspiciousTransfer) entity).getId()
                )))
                .build();
        auditRepository.save(audit);
    }

    /**
     Метод вызывается после обновления сущности и создает запись об аудите в базе данных.
     Информация об аудите содержит информацию о сущности, которая была изменена, тип операции (UPDATE),
     кем и когда была изменена, а также старое и новое значение сущности в формате JSON.
     @param entity измененная сущность, которая передается аспектом для создания записи аудита
     */
    @PostUpdate
    public void postUpdate(Object entity) {
        init();
        String type = entity.getClass().getSimpleName();
//        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        String principal = "me";
        Audit audit = auditRepository.getAuditByNewEntityJson(gson.toJson(List.of(
                type, "PRE-UPDATE", principal, ((SuspiciousTransfer) entity).getId()
        )));
        audit.setNewEntityJson(gson.toJson(entity));
        auditRepository.save(audit);
    }

    /**
     Метод, вызываемый перед удалением сущности из базы данных.
     Создает запись в таблице Audit с информацией об удалении сущности.
     @param entity удаляемая сущность
     */
    @PreRemove
    public void preRemove(Object entity) {
        init();
        Audit audit = Audit.builder()
                .entityType(entity.getClass().getSimpleName())
                .operationType("DELETE")
//                .modifiedBy(SecurityContextHolder.getContext().getAuthentication().getName())
                .modifiedBy("me")
                .modifiedAt(LocalDateTime.now())
                .build();
        auditRepository.save(audit);
    }
}
