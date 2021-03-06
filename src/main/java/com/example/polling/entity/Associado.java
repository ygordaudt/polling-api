package com.example.polling.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Associado {

    @Id
    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "NOME", nullable = false)
    private String nome;

}
