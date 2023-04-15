package com.bank.profile.entity;

import com.bank.profile.audit.AuditListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;

    @JsonIgnore
    @Column(name = "modified_by")
    private String modifiedBy;

    @JsonIgnore
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @JsonIgnore
    @Column(name = "modified_at")
    private OffsetDateTime modifiedAt;
}
