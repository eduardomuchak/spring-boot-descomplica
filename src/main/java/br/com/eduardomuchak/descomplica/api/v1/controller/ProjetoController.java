package br.com.eduardomuchak.descomplica.api.v1.controller;

import br.com.eduardomuchak.descomplica.api.v1.model.Projeto;
import br.com.eduardomuchak.descomplica.api.v1.openapi.ProjetoControllerOpenAPI;
import br.com.eduardomuchak.descomplica.api.v1.repository.ProjetoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjetoController implements ProjetoControllerOpenAPI {

    private static final Logger logger = LoggerFactory.getLogger(ProjetoController.class);

    @Autowired
    ProjetoRepository projetoRepository;

    @Override
    @GetMapping("/getAllProjetos")
    public ResponseEntity<List<Projeto>> getAllProjetos() {
        try {
            List<Projeto> projetoList = new ArrayList<>();
            projetoRepository.findAll().forEach(projetoList::add);

            if (projetoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projetoList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping("/getProjetoById/{id}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long id) {
        Optional<Projeto> projetoObj = projetoRepository.findById(id);
        if (projetoObj.isPresent()) {
            return new ResponseEntity<>(projetoObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping("/getProjetoByDescricao/{descricao}")
    public ResponseEntity<List<Projeto>> getProjetoByDescricao(@PathVariable String descricao) {
        logger.info("Searching for projects with description: {}", descricao);
        List<Projeto> projetos = projetoRepository.findByDescricao(descricao);
        if (!projetos.isEmpty()) {
            logger.info("Found {} projects with description: {}", projetos.size(), descricao);
            return new ResponseEntity<>(projetos, HttpStatus.OK);
        } else {
            logger.info("No projects found with description: {}", descricao);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping("/addProjeto")
    public ResponseEntity<Projeto> addProjeto(@RequestBody Projeto projeto) {
        try {
            Projeto projetoObj = projetoRepository.save(projeto);
            return new ResponseEntity<>(projetoObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping("/updateProjeto/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        try {
            Optional<Projeto> projetoData = projetoRepository.findById(id);
            if (projetoData.isPresent()) {
                Projeto updatedProjetoData = projetoData.get();
                updatedProjetoData.setDescricao(projeto.getDescricao());

                Projeto projetoObj = projetoRepository.save(updatedProjetoData);
                return new ResponseEntity<>(projetoObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @DeleteMapping("/deleteProjetoById/{id}")
    public ResponseEntity<HttpStatus> deleteProjeto(@PathVariable Long id) {
        try {
            projetoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @DeleteMapping("/deleteAllProjetos")
    public ResponseEntity<HttpStatus> deleteAllProjetos() {
        try {
            projetoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}