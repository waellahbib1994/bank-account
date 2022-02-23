package com.sg.bankaccount.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="idClient")
    private Long id;

    private  String firstname;

    private String lastname;

    private LocalDate birthdate;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    List<Account> accounts ;
}
