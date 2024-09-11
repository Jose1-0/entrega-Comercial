package br.org.unisenaipr.comercial.Subgrupo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.Subgrupo.entity.Subgrupo;
import br.org.unisenaipr.comercial.Subgrupo.repository.SubgrupoRepository;

@Service
public class SubgrupoService {

	@Autowired
    private SubgrupoRepository subgrupoRepository;

    public List<Subgrupo> listarSubgrupos() {
        return subgrupoRepository.findAll();
    }

    public Optional<Subgrupo> buscarSubgrupoPorId(Long id) {
        return subgrupoRepository.findById(id);
    }

    public Subgrupo salvarSubgrupo(Subgrupo subgrupo) {
        return subgrupoRepository.save(subgrupo);
    }

    public void deletarSubgrupo(Long id) {
        subgrupoRepository.deleteById(id);
    }		
	
}
