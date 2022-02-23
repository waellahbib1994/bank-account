package com.sg.bankaccount.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sg.bankaccount.enumeration.OperationTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OPERATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
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
    @ToString.Exclude
    private Account account;

}
