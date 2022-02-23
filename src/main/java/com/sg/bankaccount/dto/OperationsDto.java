package com.sg.bankaccount.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OperationsDto extends ResponseDto{
    private List<OperationDto> operations;
    private String iban;

    @Builder
    public OperationsDto(boolean success, String message, LocalDateTime timestamp, List<OperationDto> operations, String iban) {
        super(success, message, timestamp);
        this.operations = operations;
        this.iban = iban;
    }
}
