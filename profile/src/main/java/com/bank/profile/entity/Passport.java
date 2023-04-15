package com.bank.profile.entity;

import com.bank.profile.audit.AuditListener;
import com.bank.profile.configuration.PassportSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = PassportSerializer.class)
@Table(name = "passport")
public class Passport extends BaseEntity {

    private Integer series;

    private Long number;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "issued_by")
    private String issuedBy;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "division_code")
    private Integer divisionCode;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

//    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "id")
    private Registration registration;

//    @JsonIgnore
    @OneToOne(mappedBy = "passport")
    private Profile profile;
}
