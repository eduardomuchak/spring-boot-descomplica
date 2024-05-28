package br.com.eduardomuchak.descomplica.api.v1.controller;

import br.com.eduardomuchak.descomplica.api.v1.model.Tarefa;
import br.com.eduardomuchak.descomplica.api.v1.openapi.TarefaControllerOpenAPI;
import br.com.eduardomuchak.descomplica.api.v1.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController implements TarefaControllerOpenAPI {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            return new ResponseEntity<>(tarefa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<Tarefa> addTarefa(@RequestBody Tarefa tarefa) {
        Tarefa savedTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(savedTarefa, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        Tarefa updatedTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(updatedTarefa, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}