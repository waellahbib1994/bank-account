package com.sg.bankaccount.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OperationsDto extends ResponseDto{
    private List<OperationDto> operations;
    private String iban;


}
