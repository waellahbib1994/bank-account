package com.sg.bankaccount.repository;

import com.sg.bankaccount.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
