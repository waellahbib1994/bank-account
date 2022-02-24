package com.sg.bankaccount.controller;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.exception.BankAccountException;
import com.sg.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/deposit")
    public ResponseDto deposit(@RequestBody AccoutRequestDto accoutRequestDto) throws BankAccountException {
        return accountService.deposit(accoutRequestDto);
    }

    @PostMapping(value = "/withdraw")
    public ResponseDto withdraw(@RequestBody AccoutRequestDto accoutRequestDto) throws BankAccountException {
        return accountService.withdraw(accoutRequestDto);
    }

    @GetMapping(value = "/getStatement")
    public AccountDto getAccountStatement(@RequestParam String iban) throws BankAccountException {
        return accountService.accountStatement(iban);
    }

}
