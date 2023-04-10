package com.bank.history.controller;

import com.bank.history.dto.HistoryDto;

import java.util.List;

public interface HistoryController {
    public List<HistoryDto> getAllHistory();

    public HistoryDto getHistoryById(Long id);

    public void deleteHistoryById(Long id);

    public HistoryDto saveHistory(HistoryDto historyDto);

    public void updateHistory(Long id, HistoryDto historyDto);
}
