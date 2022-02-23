package com.sg.bankaccount.dto;

import com.sg.bankaccount.enumeration.OperationTypeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationDto {
    private LocalDate dateOperation;
    private float amount;
    private OperationTypeEnum type;
}
