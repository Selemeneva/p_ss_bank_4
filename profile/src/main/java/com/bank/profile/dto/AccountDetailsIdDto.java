package com.bank.profile.dto;

import com.bank.profile.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class AccountDetailsIdDto {

    private Long accountId;

    private Profile owner;
}
