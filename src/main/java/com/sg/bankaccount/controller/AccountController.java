package com.sg.bankaccount.controller;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.service.AccountService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/Account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value ="/deposit")
    public ResponseDto deposit(@RequestBody AccoutRequestDto accoutRequestDto){
        //TODO
        return  null;
    }

    @PostMapping(value ="/withdraw")
    public  ResponseDto withdraw(@RequestBody AccoutRequestDto accoutRequestDto) {
        //TODO
        return null;
    }

    @GetMapping(value="/getStatement")
    public AccountDto getAccountStatement(@RequestParam String iban){
        //TODO
        return null;
    }

}
