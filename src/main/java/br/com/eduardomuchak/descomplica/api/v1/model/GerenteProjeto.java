package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gerente_projeto")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class GerenteProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;
}