package com.sg.bankaccount.service;

import com.sg.bankaccount.dto.OperationsDto;

public interface OperationService {
    OperationsDto checkOperations(String iban);
}
