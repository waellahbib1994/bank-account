package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.entity.Account;
import com.sg.bankaccount.entity.Operation;
import com.sg.bankaccount.enumeration.AccountStateEnum;
import com.sg.bankaccount.enumeration.OperationTypeEnum;
import com.sg.bankaccount.repository.AccountRepository;
import com.sg.bankaccount.repository.OperationRepository;
import com.sg.bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseDto deposit(AccoutRequestDto accoutRequestDto) {
        Account account = accountRepository.findByIban(accoutRequestDto.getIban()).orElse(null);
        if(account!=null && account.getState().equals(AccountStateEnum.ACTIVATE)){
            Operation deposit = Operation.builder()
                    .account(account)
                    .dateOperation(LocalDate.now())
                    .amount(accoutRequestDto.getAmount())
                    .type(OperationTypeEnum.CREDIT)
                    .build();
            account.setBalance(account.getBalance() + accoutRequestDto.getAmount());
         Account accountSaved = accountRepository.save(account);
         if(accountSaved != null){
             operationRepository.save(deposit);
              return  new ResponseDto(true,"success deposit",LocalDateTime.now());

         }

        }
        return new ResponseDto(false,"failed",LocalDateTime.now());

    }

    @Override
    public ResponseDto withdraw(AccoutRequestDto accoutRequestDto) {

        Account account = accountRepository.findByIban(accoutRequestDto.getIban()).orElse(null);
        if(account != null && account.getState().equals(AccountStateEnum.ACTIVATE)){
            float verifyAmount = account.getBalance() - accoutRequestDto.getAmount();
            if(verifyAmount < 0){
                return new ResponseDto(false,"insufficient amount", LocalDateTime.now());
            }
            Operation withdraw = Operation.builder()
                    .account(account)
                    .dateOperation(LocalDate.now())
                    .amount(accoutRequestDto.getAmount())
                    .type(OperationTypeEnum.DEBIT)
                    .build();
            account.setBalance(account.getBalance() - accoutRequestDto.getAmount());
            Account accountSaved = accountRepository.save(account);
            if(accountSaved != null){
                operationRepository.save(withdraw);

                return new ResponseDto(true,"success withdraw",LocalDateTime.now());


            }

        }
          return new ResponseDto(false,"failed",LocalDateTime.now());
    }

    @Override
    public AccountDto accountStatement(String iban) {

        Account account = accountRepository.findByIban(iban).orElse(null);
        if (account != null && account.getClient()!= null){
          return   AccountDto.builder()
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
        return AccountDto.builder()
                .success(false)
                .message("failed account")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
