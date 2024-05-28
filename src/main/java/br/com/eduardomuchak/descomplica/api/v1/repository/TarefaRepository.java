package br.com.eduardomuchak.descomplica.api.v1.repository;

import br.com.eduardomuchak.descomplica.api.v1.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}