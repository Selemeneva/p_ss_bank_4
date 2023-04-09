package com.bank.antifraud.service;


import com.bank.antifraud.dto.temp.TransferDto;
import com.bank.antifraud.entity.SuspiciousTransfer;

public interface FraudService<T extends SuspiciousTransfer> {
    T check(TransferDto transferDto);
    T getById(long id);
    void deleteById(long id);
    void update(T entity);

}
