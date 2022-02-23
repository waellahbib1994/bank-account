package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.AccountDto;
import com.sg.bankaccount.dto.AccoutRequestDto;
import com.sg.bankaccount.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;


    @Test
    void should_success_deposit() {
        //Given

        //when

       ResponseDto result = accountService.deposit(new AccoutRequestDto());
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success deposit",result.getMessage());
        assertNotNull(result.getTimestamp());

    }


    @Test
    void should_success_withdraw() {
        //Given

        //when

        ResponseDto result = accountService.withdraw(new AccoutRequestDto());
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success withdraw",result.getMessage());
        assertNotNull(result.getTimestamp());

    }

    @Test
    void should_success_accountStatement() {
        //Given

        //when

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