package com.bank.antifraud.service;

import com.bank.antifraud.config.FraudProperties;
import com.bank.antifraud.dto.temp.TransferDto;
import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
import com.bank.antifraud.util.ServiceClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountFraudService extends BaseFraudService implements FraudService<SuspiciousAccountTransfer> {

    final SuspiciousAccountTransferRepository accountTransferRepository;

    protected AccountFraudService(FraudProperties properties, ServiceClient serviceClient,
                                  SuspiciousAccountTransferRepository accountTransferRepository) {
        super(properties, serviceClient);
        this.accountTransferRepository = accountTransferRepository;
    }

    @Override
    public SuspiciousAccountTransfer check(TransferDto transferDto) {
        SuspiciousAccountTransfer suspiciousAccountTransfer = SuspiciousAccountTransfer.builder()
                .accountTransferId(transferDto.id()).build();
        proceed(suspiciousAccountTransfer, transferDto);
        accountTransferRepository.save(suspiciousAccountTransfer);
        return suspiciousAccountTransfer;
    }

    @Override
    public SuspiciousAccountTransfer getById(long id) {
        return accountTransferRepository.getReferenceById(id);
    }

    @Override
    public void deleteById(long id) {
        accountTransferRepository.deleteById(id);
    }

    @Override
    public void update(SuspiciousAccountTransfer entity) {
        accountTransferRepository.save(entity);
    }

}
