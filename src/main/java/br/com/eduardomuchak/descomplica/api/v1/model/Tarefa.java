package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tarefa_id")
    private Long id;

    @Column(name = "tarefa_titulo")
    private String titulo;

    @Column(name = "tarefa_descricao")
    private String descricao;

    @Column(name = "tarefa_inicio")
    private LocalDateTime inicio;

    @Column(name = "tarefa_fim")
    private LocalDateTime fim;

    @ManyToOne
    @JoinColumn(name = "status_tarefa_id")
    private StatusTarefa statusTarefa;

    @ManyToOne
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}