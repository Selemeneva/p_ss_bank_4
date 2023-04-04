package com.bank.history.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "history", schema = "history")
@Setter
@Getter
@NoArgsConstructor
public class HistoryEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "transfer_audit_id is required")
    @Column
    private Long transfer_audit_id;
    @NotNull(message = "profile_audit_id is required")
    @Column
    private Long profile_audit_id;
    @NotNull(message = "account_audit_id is required")
    @Column
    private Long account_audit_id;
    @NotNull(message = "anti_fraud_id is required")
    @Column
    private Long anti_fraud_audit_id;
    @NotNull(message = "public_bank_info_audit_id is required")
    @Column
    private Long public_bank_info_audit_id;
    @NotNull(message = "authorization_audit_id is required")
    @Column
    private Long authorization_audit_id;

    public HistoryEntity(Long transfer_audit_id, Long profile_audit_id, Long account_audit_id, Long anti_fraud_audit_id, Long public_bank_info_audit_id, Long authorization_audit_id) {
        this.transfer_audit_id = transfer_audit_id;
        this.profile_audit_id = profile_audit_id;
        this.account_audit_id = account_audit_id;
        this.anti_fraud_audit_id = anti_fraud_audit_id;
        this.public_bank_info_audit_id = public_bank_info_audit_id;
        this.authorization_audit_id = authorization_audit_id;
    }
}
