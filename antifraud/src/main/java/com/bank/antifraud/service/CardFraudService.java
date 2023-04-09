package com.bank.antifraud.service;

import com.bank.antifraud.config.FraudProperties;
import com.bank.antifraud.dto.temp.TransferDto;
import com.bank.antifraud.entity.SuspiciousCardTransfer;
import com.bank.antifraud.repository.SuspiciousCardTransferRepository;
import com.bank.antifraud.util.ServiceClient;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardFraudService extends BaseFraudService implements FraudService<SuspiciousCardTransfer> {
    final SuspiciousCardTransferRepository cardTransferRepository;
    protected CardFraudService(FraudProperties properties, ServiceClient serviceClient,
                               SuspiciousCardTransferRepository cardTransferRepository) {
        super(properties, serviceClient);
        this.cardTransferRepository = cardTransferRepository;
    }

    @Override
    public SuspiciousCardTransfer check(TransferDto transferDto) {
        SuspiciousCardTransfer suspiciousAccountTransfer = SuspiciousCardTransfer.builder()
                .cardTransferId(transferDto.id()).build();
        proceed(suspiciousAccountTransfer, transferDto);
        cardTransferRepository.save(suspiciousAccountTransfer);
        return suspiciousAccountTransfer;
    }

    @Override
    public SuspiciousCardTransfer getById(long id) {
        return cardTransferRepository.getReferenceById(id);
    }

    @Override
    public void deleteById(long id) {
        cardTransferRepository.deleteById(id);
    }

    @Override
    public void update(SuspiciousCardTransfer entity) {
        cardTransferRepository.save(entity);
    }
}
