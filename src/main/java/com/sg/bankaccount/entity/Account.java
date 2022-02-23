package com.sg.bankaccount.entity;

import com.sg.bankaccount.enumeration.AccountStateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="idAccount")
    private Long id;

    private String iban;
    private float balance;
    private Date creationDate;
    private AccountStateEnum state;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Operation> Operations;

}
