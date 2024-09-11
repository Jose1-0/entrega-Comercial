package br.org.unisenaipr.comercial.Subgrupo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.unisenaipr.comercial.Subgrupo.entity.Subgrupo;
import br.org.unisenaipr.comercial.Subgrupo.service.SubgrupoService;

@RestController
@RequestMapping("/api/subgrupos")
public class SubgrupoController {
	@Autowired
    private SubgrupoService subgrupoService;

    @GetMapping
    public ResponseEntity<List<Subgrupo>> listarSubgrupos() {
        List<Subgrupo> subgrupos = subgrupoService.listarSubgrupos();
        return new ResponseEntity<>(subgrupos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subgrupo> buscarSubgrupoPorId(@PathVariable Long id) {
        Optional<Subgrupo> subgrupo = subgrupoService.buscarSubgrupoPorId(id);
        return subgrupo.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Subgrupo> salvarSubgrupo(@RequestBody Subgrupo subgrupo) {
        Subgrupo subgrupoSalvo = subgrupoService.salvarSubgrupo(subgrupo);
        return new ResponseEntity<>(subgrupoSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSubgrupo(@PathVariable Long id) {
        subgrupoService.deletarSubgrupo(id);
        return ResponseEntity.noContent().build();
    }
}
