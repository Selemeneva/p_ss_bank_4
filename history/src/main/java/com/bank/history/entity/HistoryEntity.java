package com.bank.history.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "history", schema = "history")
@Data
@NoArgsConstructor
public class HistoryEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long transfer_audit_id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long profile_audit_id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long account_audit_id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long anti_fraud_audit_id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long public_bank_info_audit_id;
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long authorization_audit_id;

}
