package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import com.sg.bankaccount.entity.Account;
import com.sg.bankaccount.entity.Client;
import com.sg.bankaccount.enumeration.AccountStateEnum;
import com.sg.bankaccount.repository.AccountRepository;
import com.sg.bankaccount.repository.OperationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountRepository accountRepository;

    @Mock
    OperationRepository operationRepository;


    @Test
    void should_success_deposit() {
        //Given
        Account account = createAccount();
        //when
        Mockito.when(accountRepository.findByIban(Mockito.anyString()))
                .thenReturn(Optional.of(account));
        Mockito.when(accountRepository.save(Mockito.any(Account.class)))
                .thenReturn(account);


       ResponseDto result = accountService.deposit(new AccoutRequestDto("IBAN",2500));
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success deposit",result.getMessage());
        assertNotNull(result.getTimestamp());

    }
    private Account createAccount(){
        return Account.builder()
                .client(new Client(1L,"Joe","Due", LocalDate.of(1994,07,14), new ArrayList<>()))
                .balance(25000)
                .creationDate(LocalDate.of(2022,01,02))
                .iban("15989")
                .state(AccountStateEnum.ACTIVATE)
                .build();
    }

    @Test
    void should_success_withdraw() {
        //Given
        Account account = createAccount();
        //when
        Mockito.when(accountRepository.findByIban(Mockito.anyString()))
                .thenReturn(Optional.of(account));
        Mockito.when(accountRepository.save(Mockito.any(Account.class)))
                .thenReturn(account);

        ResponseDto result = accountService.withdraw(new AccoutRequestDto("IBAN",200));
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success withdraw",result.getMessage());
        assertNotNull(result.getTimestamp());

    }

    @Test
    void should_success_accountStatement() {
        //Given
        Account account = createAccount();
        //when
        Mockito.when(accountRepository.findByIban(Mockito.anyString()))
                .thenReturn(Optional.of(account));

        AccountDto result = accountService.accountStatement("1250");
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success account statement",result.getMessage());
        assertNotNull(result.getTimestamp());
        assertEquals("15989",result.getIban());
        assertEquals(25000,result.getBalance());




    }
}