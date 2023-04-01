package com.bank.profile.service;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.repository.AccountDetailsIdRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {

    private final AccountDetailsIdRepository accountDetailsIdRepository;

    public AccountDetailsIdServiceImpl(AccountDetailsIdRepository accountDetailsIdRepository) {
        this.accountDetailsIdRepository = accountDetailsIdRepository;
    }

    @Override
    public void save(AccountDetailsId accountDetailsId) {
        accountDetailsIdRepository.save(accountDetailsId);
    }
}
