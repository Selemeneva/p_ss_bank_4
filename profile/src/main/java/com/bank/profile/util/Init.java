package com.bank.profile.util;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.dto.ActualRegistrationDto;
import com.bank.profile.dto.PassportDto;
import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.*;
import com.bank.profile.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class Init {
    private final RegistrationService registrationService;
    private final PassportService passportService;
    private final ActualRegistrationService actualRegistrationService;
    private final ProfileService profileService;
    private final AccountDetailsIdService accountDetailsIdService;

    public Init(RegistrationService registrationService, PassportService passportService, ActualRegistrationService actualRegistrationService, ProfileService profileService, AccountDetailsIdService accountDetailsIdService) {
        this.registrationService = registrationService;
        this.passportService = passportService;
        this.actualRegistrationService = actualRegistrationService;
        this.profileService = profileService;
        this.accountDetailsIdService = accountDetailsIdService;
    }

    @PostConstruct
    public void initialization() {
        Registration registration = new Registration();
        registration.setCountry("Russia");
        registration.setRegion("Europa");
        registration.setCity("Moscow");
        registration.setDistrict("Ololo");
        registration.setLocality("Ololo");
        registration.setStreet("Street");
        registration.setHouseNumber("123");
        registration.setHouseBlock("5");
        registration.setFlatNumber("123");
        registration.setIndex(12345L);
        registration.setColumns(12);
        registrationService.save(registration);

        PassportDto passportDto = new PassportDto();
        passportDto.setSeries(5);
        passportDto.setNumber(12345L);
        passportDto.setLastName("Lastname");
        passportDto.setFirstName("Firstname");
        passportDto.setMiddleName("Middlename");
        passportDto.setGender("МУЖ");
        passportDto.setBirthDate(LocalDate.ofEpochDay(2007-12-03));
        passportDto.setBirthPlace("Russia");
        passportDto.setIssuedBy("РОВД");
        passportDto.setDateOfIssue(LocalDate.ofEpochDay(2016-12-03));
        passportDto.setDivisionCode(45);
        passportDto.setExpirationDate(LocalDate.ofEpochDay(2020-12-03));
        passportDto.setRegistrationId(registration.getId());
        Passport passport = passportService.save(passportDto);

        ActualRegistrationDto actualRegistrationDto = new ActualRegistrationDto();
        actualRegistrationDto.setCountry("Russia");
        actualRegistrationDto.setIndex(12345L);
        ActualRegistration actualRegistration = actualRegistrationService.save(actualRegistrationDto);

        ProfileDto profileDto = new ProfileDto();
        profileDto.setPhoneNumber(1243455L);
        profileDto.setPassportId(passport.getId());
        profileDto.setActualRegistrationId(actualRegistration.getId());
        Profile profile = profileService.save(profileDto);

        AccountDetailsIdDto accountDetailsIdDto1 = new AccountDetailsIdDto();
        accountDetailsIdDto1.setProfileId(1L);
        accountDetailsIdDto1.setAccountId(123456L);
        AccountDetailsId accountDetailsId1 = accountDetailsIdService.save(accountDetailsIdDto1);

        AccountDetailsIdDto accountDetailsIdDto2 = new AccountDetailsIdDto();
        accountDetailsIdDto2.setProfileId(1L);
        accountDetailsIdDto2.setAccountId(9999999L);
        AccountDetailsId accountDetailsId2 = accountDetailsIdService.save(accountDetailsIdDto2);

//        Audit audit = new Audit();
//        audit.setEntityType("profile");
//        audit.setOperationType("create");
//        audit.setCreatedBy("admin");
//        audit.setModifiedBy("admin");
//        audit.setCreatedAt(OffsetDateTime.now());
//        audit.setModifieddAt(OffsetDateTime.now());
//        audit.setNewEntityJson("1232444");
//        audit.setEntityJson("1232445");
//        auditService.save(audit);
    }
}
