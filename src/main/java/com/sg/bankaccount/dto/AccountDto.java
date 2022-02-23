package com.sg.bankaccount.dto;

import com.sg.bankaccount.enumeration.AccountStateEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AccountDto extends ResponseDto{

    private  String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String iban;
    private float balance;
    private LocalDate creationDate;
    private AccountStateEnum state;


}
