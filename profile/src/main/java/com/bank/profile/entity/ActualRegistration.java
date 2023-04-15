package com.bank.profile.entity;

import com.bank.profile.audit.AuditListener;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "actual_registration")
public class ActualRegistration extends BaseEntity {

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
    @OneToOne(mappedBy = "actualRegistration")
    private Profile profile;
}
