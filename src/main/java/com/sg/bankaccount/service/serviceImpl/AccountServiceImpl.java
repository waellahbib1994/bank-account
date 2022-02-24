package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.entity.Account;
import com.sg.bankaccount.entity.Operation;
import com.sg.bankaccount.enumeration.AccountStateEnum;
import com.sg.bankaccount.enumeration.OperationTypeEnum;
import com.sg.bankaccount.exception.BankAccountException;
import com.sg.bankaccount.repository.AccountRepository;
import com.sg.bankaccount.repository.OperationRepository;
import com.sg.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OperationRepository operationRepository;

    @Override
    public ResponseDto deposit(AccoutRequestDto accoutRequestDto) throws BankAccountException {
        Account account = accountRepository.findByIban(accoutRequestDto.getIban())
                .orElseThrow(() -> new BankAccountException(HttpStatus.NOT_FOUND, "Account not found", LocalDateTime.now()));

        if (account.getState().equals(AccountStateEnum.ACTIVATE)) {
            Operation deposit = Operation.builder()
                    .account(account)
                    .dateOperation(LocalDate.now())
                    .amount(accoutRequestDto.getAmount())
                    .type(OperationTypeEnum.CREDIT)
                    .build();
            account.setBalance(account.getBalance() + accoutRequestDto.getAmount());
            try {
                Account accountSaved = accountRepository.save(account);
                operationRepository.save(deposit);
                return new ResponseDto(true, "success deposit", LocalDateTime.now());
            } catch (Exception e) {
                throw new BankAccountException(HttpStatus.SERVICE_UNAVAILABLE, "Technical problem", LocalDateTime.now());
            }
        } else {
            throw new BankAccountException(HttpStatus.FORBIDDEN, "Account disabled", LocalDateTime.now());
        }
    }

    @Override
    public ResponseDto withdraw(AccoutRequestDto accoutRequestDto) throws BankAccountException {

        Account account = accountRepository.findByIban(accoutRequestDto.getIban())
                .orElseThrow(() -> new BankAccountException(HttpStatus.NOT_FOUND, "Account not found", LocalDateTime.now()));
        if (account.getState().equals(AccountStateEnum.ACTIVATE)) {
            float verifyAmount = account.getBalance() - accoutRequestDto.getAmount();
            if (verifyAmount < 0) {
                throw new BankAccountException(HttpStatus.FORBIDDEN, "insufficient amount", LocalDateTime.now());
            }
            Operation withdraw = Operation.builder()
                    .account(account)
                    .dateOperation(LocalDate.now())
                    .amount(accoutRequestDto.getAmount())
                    .type(OperationTypeEnum.DEBIT)
                    .build();
            account.setBalance(account.getBalance() - accoutRequestDto.getAmount());
            try {
                accountRepository.save(account);
                operationRepository.save(withdraw);
                return new ResponseDto(true, "success withdraw", LocalDateTime.now());
            } catch (Exception e) {
                throw new BankAccountException(HttpStatus.SERVICE_UNAVAILABLE, "Technical problem", LocalDateTime.now());
            }
        } else {
            throw new BankAccountException(HttpStatus.FORBIDDEN, "Account disabled", LocalDateTime.now());
        }

    }

    @Override
    public AccountDto accountStatement(String iban) throws BankAccountException {

        Account account = accountRepository.findByIban(iban)
                .orElseThrow(() -> new BankAccountException(HttpStatus.NOT_FOUND, "Account not found", LocalDateTime.now()));

        return AccountDto.builder()
                .firstname(account.getClient().getFirstname())
                .lastname(account.getClient().getLastname())
                .birthdate(account.getClient().getBirthdate())
                .iban(account.getIban())
                .balance(account.getBalance())
                .creationDate(account.getCreationDate())
                .state(account.getState())
                .success(true)
                .message("success account statement")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
