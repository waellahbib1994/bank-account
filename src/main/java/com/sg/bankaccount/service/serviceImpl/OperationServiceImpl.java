package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.OperationDto;
import com.sg.bankaccount.dto.OperationsDto;
import com.sg.bankaccount.entity.Operation;
import com.sg.bankaccount.exception.BankAccountException;
import com.sg.bankaccount.repository.OperationRepository;
import com.sg.bankaccount.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Override
    public OperationsDto checkOperations(String iban) throws BankAccountException {

        List<Operation> operations = operationRepository.findByAccountIban(iban);
        List<OperationDto> listOperation = new ArrayList<>();
        if (operations != null && !operations.isEmpty()) {
            operations.forEach(o -> listOperation.add(new OperationDto(o.getDateOperation(), o.getAmount(), o.getType())));
            return OperationsDto.builder()
                    .iban(iban)
                    .operations(listOperation)
                    .success(true)
                    .message("success check operation")
                    .timestamp(LocalDateTime.now())
                    .build();
        } else {
            throw new BankAccountException(HttpStatus.NOT_FOUND, "Account not found", LocalDateTime.now());
        }
    }

}
