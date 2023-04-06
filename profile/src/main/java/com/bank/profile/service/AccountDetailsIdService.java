package com.bank.profile.service;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.entity.AccountDetailsId;

import java.util.List;

public interface AccountDetailsIdService {
    AccountDetailsId save(AccountDetailsIdDto accountDetailsIdDto);
    List<AccountDetailsId> findAll();
    AccountDetailsId getById(Long id);
    AccountDetailsId update(AccountDetailsIdDto accountDetailsIdDto, Long id);
    void delete(AccountDetailsId accountDetailsId);
}
