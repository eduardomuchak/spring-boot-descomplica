package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "projetos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projeto_id")
    private Long id;

    @Column(name = "projeto_nome")
    private String nome;

    @Column(name = "projeto_descricao")
    private String descricao;

    @Column(name = "projeto_inicio")
    private LocalDateTime inicio;

    @Column(name = "projeto_fim")
    private LocalDateTime fim;

    @Column(name = "projeto_status")
    private Boolean status;
}