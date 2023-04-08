package com.bank.history.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HistoryGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<HistoryIncorrectData> handleException(NoSuchHistoryException exception){
        HistoryIncorrectData data = new HistoryIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<HistoryIncorrectData> handleException(Exception exception){
        HistoryIncorrectData data = new HistoryIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
