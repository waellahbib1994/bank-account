package com.sg.bankaccount.controller;

import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.exception.BankAccountException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({BankAccountException.class})
    public ResponseEntity<ResponseDto> handleBankAccountException(BankAccountException ex) {
        return new ResponseEntity<>(new ResponseDto(Boolean.FALSE, ex.getMessage(), ex.getTimestamp()), new HttpHeaders(), ex.getStatus());
    }

}
