package br.com.eduardomuchak.descomplica.api.v1.repository;

import br.com.eduardomuchak.descomplica.api.v1.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByDescricao(String descricao);
}