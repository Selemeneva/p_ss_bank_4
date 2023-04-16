package com.bank.profile.entity;

import com.bank.profile.serializer.ProfileSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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

    @OneToMany(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<AccountDetailsId> accounts;

    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "actual_registration_id", referencedColumnName = "id")
    private ActualRegistration actualRegistration;
}
