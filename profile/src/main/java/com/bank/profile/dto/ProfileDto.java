package com.bank.profile.dto;

import com.bank.profile.entity.AccountDetailsId;
import lombok.Data;

import java.util.List;

@Data
public class ProfileDto {

    private Long phoneNumber;

    private String email;

    private String nameOnCard;

    private Long inn;

    private Long snils;

    private PassportDto passportDto;

    private ActualRegistrationDto actualRegistrationDto;
}
