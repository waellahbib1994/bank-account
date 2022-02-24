package com.sg.bankaccount.service;


import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.exception.BankAccountException;

public interface AccountService {

    ResponseDto deposit(AccoutRequestDto accoutRequestDto) throws BankAccountException;

    ResponseDto withdraw(AccoutRequestDto accoutRequestDto) throws BankAccountException;

    AccountDto accountStatement(String iban) throws BankAccountException;
}
