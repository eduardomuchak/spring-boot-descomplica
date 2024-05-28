package br.com.eduardomuchak.descomplica.api.v1.controller;

import br.com.eduardomuchak.descomplica.api.v1.model.Recurso;
import br.com.eduardomuchak.descomplica.api.v1.openapi.RecursoControllerOpenAPI;
import br.com.eduardomuchak.descomplica.api.v1.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecursoController implements RecursoControllerOpenAPI {

    @Autowired
    private RecursoRepository recursoRepository;

    @Override
    @GetMapping("/getAllRecursos")
    public ResponseEntity<List<Recurso>> getAllRecursos() {
        List<Recurso> recursos = recursoRepository.findAll();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Override
    @GetMapping("/getRecursoById/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id) {
        Recurso recurso = recursoRepository.findById(id).orElse(null);
        if (recurso != null) {
            return new ResponseEntity<>(recurso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/nome/{nome}")
    public ResponseEntity<List<Recurso>> getRecursosByNome(@PathVariable String nome) {
        List<Recurso> recursos = recursoRepository.findByNome(nome);
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Override
    @PostMapping("/addRecurso")
    public ResponseEntity<Recurso> addRecurso(@RequestBody Recurso recurso) {
        Recurso savedRecurso = recursoRepository.save(recurso);
        return new ResponseEntity<>(savedRecurso, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/updateRecurso/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable Long id, @RequestBody Recurso recurso) {
        recurso.setId(id);
        Recurso updatedRecurso = recursoRepository.save(recurso);
        return new ResponseEntity<>(updatedRecurso, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/deleteRecursoById/{id}")
    public ResponseEntity<HttpStatus> deleteRecurso(@PathVariable Long id) {
        recursoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}