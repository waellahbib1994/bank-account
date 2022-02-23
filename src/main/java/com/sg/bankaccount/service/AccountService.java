package com.sg.bankaccount.service;


import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;

public interface AccountService {

     ResponseDto deposit(AccoutRequestDto accoutRequestDto);

     ResponseDto withdraw(AccoutRequestDto accoutRequestDto);

     AccountDto accountStatement(String iban);
}
