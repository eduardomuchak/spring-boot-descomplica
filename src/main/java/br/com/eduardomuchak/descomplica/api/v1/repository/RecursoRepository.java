package br.com.eduardomuchak.descomplica.api.v1.repository;

import br.com.eduardomuchak.descomplica.api.v1.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    List<Recurso> findByNome(String nome);
}