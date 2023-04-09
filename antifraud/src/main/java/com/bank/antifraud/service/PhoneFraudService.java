package com.bank.antifraud.service;

import com.bank.antifraud.config.FraudProperties;
import com.bank.antifraud.dto.temp.TransferDto;
import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import com.bank.antifraud.repository.SuspiciousPhoneTransferRepository;
import com.bank.antifraud.util.ServiceClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneFraudService extends BaseFraudService implements FraudService<SuspiciousPhoneTransfer> {

    final SuspiciousPhoneTransferRepository phoneTransferRepository;
    protected PhoneFraudService(FraudProperties properties, ServiceClient serviceClient,
                                SuspiciousPhoneTransferRepository suspiciousPhoneTransferRepository) {
        super(properties, serviceClient);
        this.phoneTransferRepository = suspiciousPhoneTransferRepository;
    }

    @Override
    public SuspiciousPhoneTransfer check(TransferDto transferDto) {
        SuspiciousPhoneTransfer suspiciousAccountTransfer = SuspiciousPhoneTransfer.builder()
                .phoneTransferId(transferDto.id()).build();
        proceed(suspiciousAccountTransfer, transferDto);
        phoneTransferRepository.save(suspiciousAccountTransfer);
        return suspiciousAccountTransfer;
    }

    @Override
    public SuspiciousPhoneTransfer getById(long id) {
        return phoneTransferRepository.getReferenceById(id);
    }

    @Override
    public void deleteById(long id) {
        phoneTransferRepository.deleteById(id);
    }

    @Override
    public void update(SuspiciousPhoneTransfer entity) {
        phoneTransferRepository.save(entity);
    }
}
