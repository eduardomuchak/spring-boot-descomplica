package br.com.eduardomuchak.descomplica.api.v1.openapi;

import br.com.eduardomuchak.descomplica.api.v1.model.Projeto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Projetos")
public interface ProjetoControllerOpenAPI {

    @Operation(summary = "Retorna todos os projetos")
    ResponseEntity<List<Projeto>> getAllProjetos();

    @Operation(summary = "Retorna um projeto pelo ID")
    ResponseEntity<Projeto> getProjetoById(@PathVariable Long id);

    @Operation(summary = "Retorna um projeto pela descrição")
    ResponseEntity<List<Projeto>> getProjetoByDescricao(@PathVariable String descricao);

    @Operation(summary = "Adiciona um projeto")
    ResponseEntity<Projeto> addProjeto(@RequestBody Projeto projeto);

    @Operation(summary = "Atualiza um projeto pelo ID")
    ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto);

    @Operation(summary = "Deleta um projeto pelo ID")
    ResponseEntity<HttpStatus> deleteProjeto(@PathVariable Long id);

    @Operation(summary = "Deleta todos os projetos")
    ResponseEntity<HttpStatus> deleteAllProjetos();
}