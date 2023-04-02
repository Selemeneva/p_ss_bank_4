package com.bank.profile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String region;

    private String city;

    private String district;

    private String locality;

    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "house_block")
    private String houseBlock;

    @Column(name = "flat_number")
    private String flatNumber;

    private Long index;

    @JsonIgnore
    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private Passport passport;


    //Это что такое вообще? Может вызвать ошибку
    private Integer columns;
}
