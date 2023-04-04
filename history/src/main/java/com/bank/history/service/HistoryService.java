package com.bank.history.service;

import com.bank.history.dto.HistoryDto;

import java.util.List;

public interface HistoryService {
    public List<HistoryDto> getAllHistory();

    public HistoryDto getHistoryById(Long id);

    public void deleteHistory(Long id);

    HistoryDto saveHistory(HistoryDto saveHistory);

    public HistoryDto updateHistory(Long id, HistoryDto historyDto);

}
