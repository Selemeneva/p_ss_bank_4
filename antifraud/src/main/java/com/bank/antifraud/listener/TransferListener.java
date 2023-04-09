package com.bank.antifraud.listener;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.entity.SuspiciousTransfer;
import com.bank.antifraud.repository.AuditRepository;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.core.context.SecurityContextHolder;


import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferListener {

    @Autowired AuditRepository auditRepository;
    final Gson gson = new Gson();

    @PrePersist
    public void prePersist(Object entity) {
        Audit audit = Audit.builder()
                .entityType(entity.getClass().getSimpleName())
                .operationType("CREATE")
                .createdBy(SecurityContextHolder.getContext().getAuthentication().getName())
                .createdAt(LocalDateTime.now())
                .entityJson(gson.toJson(entity))
                .build();
        auditRepository.save(audit);
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        String type = entity.getClass().getSimpleName();
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
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

    @PostUpdate
    public void postUpdate(Object entity) {
        String type = entity.getClass().getSimpleName();
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        Audit audit = auditRepository.getAuditByNewEntityJson(gson.toJson(List.of(
                type, "PRE-UPDATE", principal, ((SuspiciousTransfer) entity).getId()
        )));
        audit.setNewEntityJson(gson.toJson(entity));
        auditRepository.save(audit);
    }

    @PreRemove
    public void preRemove(Object entity) {
        Audit audit = Audit.builder()
                .entityType(entity.getClass().getSimpleName())
                .operationType("DELETE")
                .modifiedBy(SecurityContextHolder.getContext().getAuthentication().getName())
                .modifiedAt(LocalDateTime.now())
                .build();
        auditRepository.save(audit);
    }
}
