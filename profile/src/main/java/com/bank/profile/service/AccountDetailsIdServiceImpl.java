package com.bank.profile.service;

import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.repository.AccountDetailsIdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {

    private final AccountDetailsIdRepository accountDetailsIdRepository;

    public AccountDetailsIdServiceImpl(AccountDetailsIdRepository accountDetailsIdRepository) {
        this.accountDetailsIdRepository = accountDetailsIdRepository;
    }

    @Override
    public void save(AccountDetailsId accountDetailsId) {
        accountDetailsId.setId(null);
        accountDetailsIdRepository.save(accountDetailsId);
    }

    @Override
    public List<AccountDetailsId> findAll() {
        return accountDetailsIdRepository.findAll();
    }

    @Override
    public boolean existById(Long id) {
        return accountDetailsIdRepository.existsById(id);
    }

    @Override
    public AccountDetailsId findById(Long id) {
        return accountDetailsIdRepository.getReferenceById(id);
    }

    @Override
    public void update(AccountDetailsId accountDetailsId) {
        accountDetailsIdRepository.save(accountDetailsId);
    }

    @Override
    public void deleteById(Long id) {
        accountDetailsIdRepository.deleteById(id);
    }
}
