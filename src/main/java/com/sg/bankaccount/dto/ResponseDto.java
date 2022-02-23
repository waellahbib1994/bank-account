package com.sg.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ResponseDto {

    protected   boolean success;
    protected String message;
    protected LocalDateTime timestamp;

}
