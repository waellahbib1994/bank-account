package com.sg.bankaccount.entity;

import com.sg.bankaccount.enumeration.AccountStateEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="idAccount")
    private Long id;

    private String iban;
    private float balance;
    private LocalDate creationDate;
    private AccountStateEnum state;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @ToString.Exclude
    private Client client;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private List<Operation> Operations;

}
