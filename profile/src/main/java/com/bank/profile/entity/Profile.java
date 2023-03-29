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

    @Column(name = "email")
    private String email;

    @Column(name = "name_of_card")
    private String nameOfCard;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "snils")
    private Long snils;

    @OneToMany(mappedBy = "owner")
    private List<AccountDetailsId> accounts;


}
