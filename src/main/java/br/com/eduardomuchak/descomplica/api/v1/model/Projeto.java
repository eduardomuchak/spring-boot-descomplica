package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @Column
    private String descricao;

    // Add other fields as per your requirements
}