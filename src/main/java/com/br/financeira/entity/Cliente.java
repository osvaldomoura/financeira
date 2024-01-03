package com.br.financeira.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "CLIENTE", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DynamicInsert
@DynamicUpdate
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "CLI_NOME", nullable = false)
    @Setter
    private String nome;

    @Column(name = "CLI_CPF", nullable = false, unique = true)
    @Setter
    private String cpf;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Banco> bancos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLI_VENDEDOR_ID", referencedColumnName = "VEN_ID", nullable = false)
    private Vendedor vendedor;

}
