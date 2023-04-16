package com.bank.history.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "history", schema = "history")
@Data
@NoArgsConstructor
public class HistoryEntity {
    public static final int MAX_NAME_LENGTH = 50;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long transferAuditId;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long profileAuditId;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long accountAuditId;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long antiFraudAuditId;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long publicBankInfoAuditId;
    @Size(min = 1, max = MAX_NAME_LENGTH, message = "Name must be between 1 and 50 characters")
    @Positive(message = "Amount must be positive")
    @Column
    private Long authorizationAuditId;

}
