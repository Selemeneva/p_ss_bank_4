package com.bank.antifraud.util;

import com.bank.antifraud.dto.temp.ProfileDetailsDto;
import com.bank.antifraud.dto.temp.TransferDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceClientImpl implements ServiceClient {
    @Override
    public boolean isUserAuth(long profileId) {
        return false;
    }

    @Override
    public ProfileDetailsDto getProfileDetailsById(long accountDetailsId) {
        return null;
    }

    @Override
    public List<TransferDto> getTransfersByAccountId(long accountId) {
        return null;
    }

    @Override
    public List<TransferDto> getIncomingTransfersByTransferDetails(long transferDetails) {
        return null;
    }

    @Override
    public boolean hasBlockedTransfersPerDay(long profileId) {
        return false;
    }
}
