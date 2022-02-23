package com.sg.bankaccount.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class ResponseDto {

    private  boolean success;
    private String message;
    private LocalDateTime timestamp;

}
