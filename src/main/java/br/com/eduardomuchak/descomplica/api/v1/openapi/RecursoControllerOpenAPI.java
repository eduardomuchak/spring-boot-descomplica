package br.com.eduardomuchak.descomplica.api.v1.openapi;

import br.com.eduardomuchak.descomplica.api.v1.model.Recurso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Recursos")
public interface RecursoControllerOpenAPI {

    @Operation(summary = "Retorna todos os recursos")
    ResponseEntity<List<Recurso>> getAllRecursos();

    @Operation(summary = "Retorna um recurso pelo ID")
    ResponseEntity<Recurso> getRecursoById(@PathVariable Long id);

    @Operation(summary = "Adiciona um recurso")
    ResponseEntity<Recurso> addRecurso(@RequestBody Recurso recurso);

    @Operation(summary = "Atualiza um recurso pelo ID")
    ResponseEntity<Recurso> updateRecurso(@PathVariable Long id, @RequestBody Recurso recurso);

    @Operation(summary = "Deleta um recurso pelo ID")
    ResponseEntity<HttpStatus> deleteRecurso(@PathVariable Long id);
}