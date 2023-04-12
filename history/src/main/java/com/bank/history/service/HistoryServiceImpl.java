package com.bank.history.service;

import com.bank.history.dto.HistoryDto;
import com.bank.history.entity.HistoryEntity;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public List<HistoryDto> getAllHistory() {
        final List<HistoryEntity> entities = historyRepository.findAll();
        return entities.stream().map(HistoryMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HistoryDto getHistoryById(Long id) {
        final Optional<HistoryEntity> entity = historyRepository.findById(id);
        return entity.map(HistoryMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    @Transactional
    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public HistoryDto saveHistory(HistoryDto saveHistory) {
        final HistoryEntity historyEntity = historyRepository.save(HistoryMapper.INSTANCE.toEntity(saveHistory));
        final HistoryDto historyDto = HistoryMapper.INSTANCE.toDto(historyEntity);
        return historyDto;
    }

    @Override
    @Transactional
    public HistoryDto updateHistory(Long id, HistoryDto updateHistory) {
        final HistoryEntity historyEntity = historyRepository.save(HistoryMapper.INSTANCE.toEntity(updateHistory));
        return HistoryMapper.INSTANCE.toDto(historyEntity);
    }
}

