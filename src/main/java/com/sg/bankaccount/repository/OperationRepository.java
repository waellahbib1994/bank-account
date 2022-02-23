package com.sg.bankaccount.repository;

import com.sg.bankaccount.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    List<Operation> findByAccountIban(String iban);
}
