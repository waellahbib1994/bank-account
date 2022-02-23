package com.sg.bankaccount.service.serviceImpl;

import com.sg.bankaccount.dto.OperationsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OperationServiceImplTest {

    @InjectMocks
    OperationServiceImpl operationService;


    @Test
    void should_success_checkOperations() {
        //Given

        //when

        OperationsDto result = operationService.checkOperations("751");
        //then
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals("success checked operation",result.getMessage());
        assertNotNull(result.getTimestamp());
        assertEquals("751",result.getIban());



    }
}