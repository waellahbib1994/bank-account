package com.sg.bankaccount.dto;

import com.sg.bankaccount.enumeration.AccountStateEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
public class AccountDto extends ResponseDto{

    private  String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String iban;
    private float balance;
    private LocalDate creationDate;
    private AccountStateEnum state;

    @Builder
    public AccountDto(boolean success, String message, LocalDateTime timestamp, String firstname, String lastname, LocalDate birthdate,
                      String iban, float balance, LocalDate creationDate, AccountStateEnum state) {
        super(success, message, timestamp);
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.iban = iban;
        this.balance = balance;
        this.creationDate = creationDate;
        this.state = state;
    }
}
