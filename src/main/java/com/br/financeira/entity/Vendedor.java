package com.br.financeira.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "VENDEDOR", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DynamicInsert
@DynamicUpdate
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEN_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "VEN_NOME")
    @Setter
    private String nome;

    @Column(name = "VEN_CPF")
    @Setter
    private String cpf;
}
