package com.bank.history.controller;

import com.bank.history.dto.HistoryDto;

import java.util.List;

public interface HistoryController {
    List<HistoryDto> getAllHistory();

    HistoryDto getHistoryById(Long id);

    void deleteHistoryById(Long id);

    HistoryDto saveHistory(HistoryDto historyDto);

    void updateHistory(Long id, HistoryDto historyDto);
}
