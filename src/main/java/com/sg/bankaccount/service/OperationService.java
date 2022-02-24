package com.sg.bankaccount.service;

import com.sg.bankaccount.dto.OperationsDto;
import com.sg.bankaccount.exception.BankAccountException;

public interface OperationService {
    OperationsDto checkOperations(String iban) throws BankAccountException;
}
