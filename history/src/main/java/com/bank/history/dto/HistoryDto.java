package com.bank.history.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность истории записей")
public class HistoryDto {
    @Schema(description = "Идентификатор")
    private Long id;
    @NotNull(message = "transfer_audit_id is required")
    @Schema(description = "Идентификатор записи из сущности transfer_audit")
    private Long transfer_audit_id;
    @NotNull(message = "profile_audit_id is required")
    @Schema(description = "Идентификатор записи из сущности profile_audit")
    private Long profile_audit_id;
    @NotNull(message = "account_audit_id is required")
    @Schema(description = "Идентификатор записи из сущности account_audit")
    private Long account_audit_id;
    @NotNull(message = "anti_fraud_id is required")
    @Schema(description = "Идентификатор записи из сущности anti_fraud_audit")
    private Long anti_fraud_audit_id;
    @NotNull(message = "public_bank_info_audit_id is required")
    @Schema(description = "Идентификатор записи из сущности public_bank_info_audit")
    private Long public_bank_info_audit_id;
    @NotNull(message = "authorization_audit_id is required")
    @Schema(description = "Идентификатор записи из сущности authorization_audit")
    private Long authorization_audit_id;

}
