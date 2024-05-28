package br.com.eduardomuchak.descomplica.api.v1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "status_tarefa")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StatusTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_tarefa_id")
    private Long id;

    @Column(name = "status_descricao")
    private String descricao;
}