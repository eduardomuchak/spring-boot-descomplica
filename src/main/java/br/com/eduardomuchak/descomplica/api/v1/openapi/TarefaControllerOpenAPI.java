package br.com.eduardomuchak.descomplica.api.v1.openapi;

import br.com.eduardomuchak.descomplica.api.v1.model.Tarefa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Tarefas")
public interface TarefaControllerOpenAPI {

    @Operation(summary = "Retorna todas as tarefas")
    ResponseEntity<List<Tarefa>> getAllTarefas();

    @Operation(summary = "Retorna uma tarefa pelo ID")
    ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id);

    @Operation(summary = "Adiciona uma tarefa")
    ResponseEntity<Tarefa> addTarefa(@RequestBody Tarefa tarefa);

    @Operation(summary = "Atualiza uma tarefa pelo ID")
    ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa);

    @Operation(summary = "Deleta uma tarefa pelo ID")
    ResponseEntity<HttpStatus> deleteTarefa(@PathVariable Long id);
}