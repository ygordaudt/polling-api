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
    private Long cpf;

    @Column(nullable = false)
    private String nome;

}
