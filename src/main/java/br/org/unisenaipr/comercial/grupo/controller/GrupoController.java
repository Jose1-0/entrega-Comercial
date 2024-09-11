package br.org.unisenaipr.comercial.grupo.controller;

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

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.service.GrupoService;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {
	
	 	@Autowired
	    private GrupoService grupoService;

	    @GetMapping
	    public ResponseEntity<List<Grupo>> listarGrupos() {
	        List<Grupo> grupos = grupoService.listarGrupos();
	        return new ResponseEntity<>(grupos, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Grupo> buscarGrupoPorId(@PathVariable Long id) {
	        Optional<Grupo> grupo = grupoService.buscarGrupoPorId(id);
	        return grupo.map(ResponseEntity::ok)
	                    .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Grupo> salvarGrupo(@RequestBody Grupo grupo) {
	        Grupo grupoSalvo = grupoService.salvarGrupo(grupo);
	        return new ResponseEntity<>(grupoSalvo, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarGrupo(@PathVariable Long id) {
	        grupoService.deletarGrupo(id);
	        return ResponseEntity.noContent().build();
	    }	

}
