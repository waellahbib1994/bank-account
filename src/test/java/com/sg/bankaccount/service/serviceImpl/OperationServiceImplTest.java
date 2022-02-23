package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.OperationsDto;
import com.sg.bankaccount.entity.Account;
import com.sg.bankaccount.entity.Client;
import com.sg.bankaccount.enumeration.AccountStateEnum;
import com.sg.bankaccount.repository.AccountRepository;
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
class OperationServiceImplTest {

    @InjectMocks
    OperationServiceImpl operationService;

    @Mock
    AccountRepository accountRepository;


    @Test
    void should_success_checkOperations() {
        //Given
        Account account = createAccount();
        //when
        Mockito.when(accountRepository.findByIban(Mockito.anyString()))
                .thenReturn(Optional.of(account));
        OperationsDto result = operationService.checkOperations("751");
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success check operation",result.getMessage());
        assertNotNull(result.getTimestamp());
        assertEquals("751",result.getIban());



    }
    private Account createAccount(){
        return Account.builder()
                .client(new Client(1L,"Joe","Due", LocalDate.of(1994,07,14), new ArrayList<>()))
                .balance(25000)
                .creationDate(LocalDate.of(2022,01,02))
                .iban("751")
                .state(AccountStateEnum.ACTIVATE)
                .build();
    }
}