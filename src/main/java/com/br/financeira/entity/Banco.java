package com.br.financeira.entity;

import com.br.financeira.enums.NomeBanco;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "BANCO", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DynamicInsert
@DynamicUpdate
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANC_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "BANC_NOME_BANCO")
    @Enumerated(EnumType.STRING)
    private NomeBanco nomeBanco;

    @Column(name = "BANC_AGENCIA")
    @Setter
    private Integer agencia;

    @Column(name = "BANC_CONTA")
    @Setter
    private String conta;

}
