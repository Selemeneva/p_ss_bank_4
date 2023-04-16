package com.bank.profile.entity;

import com.bank.profile.serializer.AccountDetailsIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = AccountDetailsIdSerializer.class)
@Table(name = "account_details_id")
public class AccountDetailsId extends BaseEntity {

    @Column(name = "account_id")
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile owner;

}
