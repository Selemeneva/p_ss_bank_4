package com.bank.history.controller;

import com.bank.history.dto.HistoryDto;
import com.bank.history.exception_handling.NoSuchHistoryException;
import com.bank.history.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Контроллер записей истории", description = "получаем и редактируем данные по записям в истории")
public class HistoryControllerImpl implements HistoryController {

    private final HistoryService historyService;
    private static final Logger logger = LoggerFactory.getLogger(HistoryControllerImpl.class);

    @Autowired
    public HistoryControllerImpl(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping()
    @Operation(
            summary = "Получение всех записей",
            description = "Позволяет вывести полный список записей в истории"
    )
    public List<HistoryDto> getAllHistory() {
        logger.info("Получили запрос на получение всей истории");
        return historyService.getAllHistory();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение записи по id",
            description = "Позволяет вывести запись из истории по id"
    )
    public HistoryDto getHistoryById(@PathVariable Long id) {
        logger.info("получили запрос на получение истории по id =  {}", id);
        HistoryDto historyDto = historyService.getHistoryById(id);
        if (historyDto == null){
            throw new NoSuchHistoryException("History with id = " + id + " does not exist.");
        }
        return historyDto;
    }


    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление записи из истории по id",
            description = "Позволяет удалить запись из истории по id, ничего не возвращает"
    )
    public void deleteHistoryById(@PathVariable Long id) {
        logger.info("получили запрос на удалении истории по id = {}", id);
        HistoryDto historyDto = historyService.getHistoryById(id);
        if (historyDto == null){
            throw new NoSuchHistoryException("History with id = " + id + " does not exist.");
        }
        historyService.deleteHistory(id);
    }

    @PostMapping
    @Operation(
            summary = "Создание новой записи в истории",
            description = "Позволяет добавить в историю новую запись и вернуть представление добавленной записи"
    )
    public HistoryDto saveHistory(@RequestBody HistoryDto historyDto) {
        logger.info("получили запрос на сохранение истории");
        return historyService.saveHistory(historyDto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Изменение записи в истории",
            description = "Позволяет изменить существующую запись в истории, ничего не возвращает"
    )
    public void updateHistory(@PathVariable("id") Long id, @RequestBody HistoryDto historyDto) {
        logger.info("получили запрос редактирование истории по id = {}", id);
        HistoryDto historyDtoOld = historyService.getHistoryById(id);
        if (historyDtoOld == null){
            throw new NoSuchHistoryException("History with id = " + id + " does not exist.");
        }
        historyService.updateHistory(id, historyDto);
    }
}
