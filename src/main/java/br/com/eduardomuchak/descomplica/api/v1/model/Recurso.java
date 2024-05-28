package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recursos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recurso_id")
    private Long id;

    @Column(name = "recurso_nome")
    private String nome;

    @Column(name = "recurso_funcao")
    private String funcao;
}