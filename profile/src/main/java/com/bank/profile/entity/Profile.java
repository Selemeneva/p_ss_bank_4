package com.bank.profile.entity;

import com.bank.profile.audit.AuditListener;
import com.bank.profile.configuration.ProfileSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = ProfileSerializer.class)
@Table(name = "profile")
public class Profile extends BaseEntity {

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String email;

    @Column(name = "name_on_card")
    private String nameOnCard;

    private Long inn;

    private Long snils;

//    @JsonIgnore
    @OneToMany(mappedBy = "owner")
    private List<AccountDetailsId> accounts;

    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "actual_registration_id", referencedColumnName = "id")
    private ActualRegistration actualRegistration;
}
