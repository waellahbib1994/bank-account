package com.sg.bankaccount.controller;


import com.sg.bankaccount.dto.OperationsDto;
import com.sg.bankaccount.exception.BankAccountException;
import com.sg.bankaccount.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Operation")
public class OperationController {

    @Autowired
    OperationService operationService;

    @GetMapping(value = "/check")
    public OperationsDto checkOperations(@RequestParam String iban) throws BankAccountException {
        return operationService.checkOperations(iban);
    }
}
