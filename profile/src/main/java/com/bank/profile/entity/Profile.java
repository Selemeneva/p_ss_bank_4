package com.bank.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private Long phoneNumber;

    private String email;

    @Column(name = "name_on_card")
    private String nameOnCard;

    private Long inn;

    private Long snils;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<AccountDetailsId> accounts;

    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @OneToOne
    @JoinColumn(name = "actual_registration_id", referencedColumnName = "id")
    private ActualRegistration actualRegistration;
}
