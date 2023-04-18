package com.bank.account.Service;

import com.bank.account.Entity.AccountDetails;
import com.bank.account.Repository.AccountDetailsRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс AccountDetailsServiceImpl представляет реализацию интерфейса AccountDetailsService,
 * который предоставляет сервис для управления банковскими счетами.
 * <p>
 * Этот класс отмечен
 * аннотацией @Service, что говорит о том, что он является сервисным классом в Spring framework.
 * Его методы обеспечивают поиск, создание, обновление и удаление объектов AccountDetails
 * в БД, а также получение списка всех существующих счетов.
 */
@Service
@Transactional
@AllArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {

    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    @Transactional(readOnly = true)
    public AccountDetails findById(Long id) {
        return accountDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Номер счета " + id + " не найден"));
    }

    @Override
    public void createAccount(AccountDetails accountDetails) {
        accountDetailsRepository.save(accountDetails);
    }

    @Override
    public void updateAccount(AccountDetails accountDetails) {
        AccountDetails accountDetailsExisting = accountDetailsRepository.getById(accountDetails.getId());
        if (accountDetailsExisting != null) {
            accountDetailsExisting.setPassportId(accountDetails.getPassportId());
            accountDetailsExisting.setAccountNumber(accountDetails.getAccountNumber());
            accountDetailsExisting.setBankDetailsId(accountDetails.getBankDetailsId());
            accountDetailsExisting.setMoney(accountDetails.getMoney());
            accountDetailsExisting.setNegativeBalance(accountDetails.getNegativeBalance());
            accountDetailsExisting.setProfileId(accountDetails.getProfileId());

            accountDetailsRepository.saveAndFlush(accountDetailsExisting);
        } else {
            throw new RuntimeException("Account not found with id " + accountDetails.getId());
        }
    }

    @Override
    public void deleteAccountById(Long id) {
        accountDetailsRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<AccountDetails> getAllAccounts() {
        return new HashSet<>(accountDetailsRepository.findAll());
    }


}
