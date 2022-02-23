package com.sg.bankaccount.entity;

import com.sg.bankaccount.enumeration.OperationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "OPERATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="idOperation")
    private Long id;


    private LocalDate dateOperation;
    private float amount;
    private OperationTypeEnum type;

    @ManyToOne
    @JoinColumn(name="idAccount")
    private Account account;

}
