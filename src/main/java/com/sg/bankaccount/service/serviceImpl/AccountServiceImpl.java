package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public ResponseDto deposit(AccoutRequestDto accoutRequestDto) {
        //TODO
        return null;
    }

    @Override
    public ResponseDto withdraw(AccoutRequestDto accoutRequestDto) {
        //TODO
        return null;
    }

    @Override
    public AccountDto accountStatement(String iban) {
        //TODO
        return null;
    }
}
