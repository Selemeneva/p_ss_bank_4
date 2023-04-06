package com.bank.profile.service;

import com.bank.profile.dto.AccountDetailsIdDto;
import com.bank.profile.entity.AccountDetailsId;
import com.bank.profile.entity.Profile;
import com.bank.profile.mapper.AccountDetailsIdMapper;
import com.bank.profile.repository.AccountDetailsIdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailsIdServiceImpl implements AccountDetailsIdService {

    private final AccountDetailsIdRepository accountDetailsIdRepository;
    private final AccountDetailsIdMapper accountDetailsIdMapper;
    private final ProfileService profileService;

    public AccountDetailsIdServiceImpl(AccountDetailsIdRepository accountDetailsIdRepository, AccountDetailsIdMapper accountDetailsIdMapper, ProfileService profileService) {
        this.accountDetailsIdRepository = accountDetailsIdRepository;
        this.accountDetailsIdMapper = accountDetailsIdMapper;
        this.profileService = profileService;
    }

    @Override
    public List<AccountDetailsId> findAll() {
        return accountDetailsIdRepository.findAll();
    }

    @Override
    public AccountDetailsId getById(Long id) {
        return accountDetailsIdRepository.getReferenceById(id);
    }

    @Override
    public AccountDetailsId save(AccountDetailsIdDto accountDetailsIdDto) {
        AccountDetailsId accountDetailsId = accountDetailsIdMapper.toEntity(accountDetailsIdDto);
        Profile profile = profileService.getById(accountDetailsIdDto.getProfileId());
        accountDetailsId.setOwner(profile);
        accountDetailsIdRepository.save(accountDetailsId);
        return accountDetailsId;
    }

    @Override
    public AccountDetailsId update(AccountDetailsIdDto accountDetailsIdDto, Long id) {
        AccountDetailsId accountDetailsId = accountDetailsIdMapper.toEntity(accountDetailsIdDto);
        accountDetailsId.setId(id);
        Profile profile = profileService.getById(accountDetailsIdDto.getProfileId());
        accountDetailsId.setOwner(profile);
        accountDetailsIdRepository.save(accountDetailsId);
        return accountDetailsId;
    }

    @Override
    public void delete(AccountDetailsId accountDetailsId) {
        accountDetailsIdRepository.delete(accountDetailsId);
    }
}
