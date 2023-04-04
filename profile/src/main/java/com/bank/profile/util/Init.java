package com.bank.profile.util;

import com.bank.profile.dto.ProfileDto;
import com.bank.profile.entity.*;
import com.bank.profile.mapper.*;
import com.bank.profile.service.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Component
public class Init {
    private final RegistrationService registrationService;
    private final PassportService passportService;
    private final ActualRegistrationService actualRegistrationService;
    private final ProfileService profileService;
    private final AccountDetailsIdService accountDetailsIdService;
    private final AuditService auditService;
    private final ProfileMapper profileMapper;


    public Init(RegistrationService registrationService, PassportService passportService, ActualRegistrationService actualRegistrationService, ProfileService profileService, AccountDetailsIdService accountDetailsIdService, AuditService auditService, ProfileMapper profileMapper) {
        this.registrationService = registrationService;
        this.passportService = passportService;
        this.actualRegistrationService = actualRegistrationService;
        this.profileService = profileService;
        this.accountDetailsIdService = accountDetailsIdService;
        this.auditService = auditService;

        this.profileMapper = profileMapper;
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

        Passport passport = new Passport();
        passport.setSeries(5);
        passport.setNumber(12345L);
        passport.setLastName("Lastname");
        passport.setFirstName("Firstname");
        passport.setMiddleName("Middlename");
        passport.setGender("МУЖ");
        passport.setBirthDate(LocalDate.ofEpochDay(2007-12-03));
        passport.setBirthPlace("Russia");
        passport.setIssuedBy("РОВД");
        passport.setDateOfIssue(LocalDate.ofEpochDay(2016-12-03));
        passport.setDivisionCode(45);
        passport.setExpirationDate(LocalDate.ofEpochDay(2020-12-03));
        passport.setRegistration(registration);

        ActualRegistration actualRegistration = new ActualRegistration();
        actualRegistration.setCountry("Russia");
        actualRegistration.setIndex(12345L);

        Profile profile = new Profile();
        profile.setPhoneNumber(1243455L);
        profile.setPassport(passport);
        profile.setActualRegistration(actualRegistration);
        ProfileDto profileDto = profileMapper.toDto(profile);
        profileService.save(profileDto);

//        AccountDetailsId accountDetailsId1 = new AccountDetailsId();
//        accountDetailsId1.setOwner(profile);
//        accountDetailsId1.setAccountId(123456L);
//        accountDetailsId1.setOwner(profile);
//        accountDetailsIdService.save(accountDetailsId1);
//
//        AccountDetailsId accountDetailsId2 = new AccountDetailsId();
//        accountDetailsId2.setOwner(profile);
//        accountDetailsId2.setAccountId(123456789L);
//        accountDetailsIdService.save(accountDetailsId2);

        Audit audit = new Audit();
        audit.setEntityType("profile");
        audit.setOperationType("create");
        audit.setCreatedBy("admin");
        audit.setModifiedBy("admin");
        audit.setCreatedAt(OffsetDateTime.now());
        audit.setModifieddAt(OffsetDateTime.now());
        audit.setNewEntityJson("1232444");
        audit.setEntityJson("1232445");
        auditService.save(audit);
    }
}
