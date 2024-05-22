package br.com.eduardomuchak.descomplica.api.v1.repository;

import br.com.eduardomuchak.descomplica.api.v1.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByDescricao(String descricao);
}