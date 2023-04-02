package com.bank.profile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "id")
    private Registration registration;

    @JsonIgnore
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Profile profile;
}
