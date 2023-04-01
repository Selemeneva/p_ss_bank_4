package com.bank.profile.dto;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.entity.ActualRegistration;
import com.bank.profile.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ProfileDto {

    private Long id;

    private Long phoneNumber;

    private String email;

    private String nameOnCard;

    private Long inn;

    private Long snils;

    private List<AccountDetailsId> accounts;

    private Passport passport;

    private ActualRegistration actualRegistration;
}
