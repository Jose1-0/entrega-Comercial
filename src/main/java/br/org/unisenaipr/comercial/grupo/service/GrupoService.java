package br.org.unisenaipr.comercial.grupo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> buscarGrupoPorId(Long id) {
        return grupoRepository.findById(id);
    }

    public Grupo salvarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void deletarGrupo(Long id) {
        grupoRepository.deleteById(id);
    }	
}
