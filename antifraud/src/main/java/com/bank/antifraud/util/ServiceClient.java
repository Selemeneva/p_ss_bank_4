package com.bank.antifraud.util;


import com.bank.antifraud.dto.temp.ProfileDetailsDto;
import com.bank.antifraud.dto.temp.TransferDto;

import java.util.List;


public interface ServiceClient {

    //проверка аутентификации пользователя
    boolean isUserAuth(long profileId);

    //Получить счета пользователя
    ProfileDetailsDto getProfileDetailsById(long accountDetailsId);


    //Получаем платежи пользователя из transfer сервиса, пригодится для:
    // среднего чека, первой транзакции, использовался ли указанный счет и тд.
    List<TransferDto> getTransfersByAccountId(long accountId);

    //Получаем переводы по реквизитам (карта/номер/счет)
    List<TransferDto> getIncomingTransfersByTransferDetails(long transferDetails);
    //Есть ли у клиента заблокированные платежи за последние сутки
    boolean hasBlockedTransfersPerDay(long profileId);


}
