package br.org.unisenaipr.comercial.fabricante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.fabricante.entity.Fabricante;
import br.org.unisenaipr.comercial.fabricante.repositorio.FabricanteRepository;

@Service
public class FabricanteService {
	
	
	private FabricanteRepository fabricanteRepository;
	
	public FabricanteService(FabricanteRepository fabricanteRepository) {
		this.fabricanteRepository = fabricanteRepository;
	}

	public void saveFabricante(Fabricante fabricante) {
		fabricanteRepository.save(fabricante);
	}

	public void updateFabricante(Fabricante fabricante) {
		fabricanteRepository.save(fabricante);
	}
	
	public void deleteFabricante(Fabricante fabricante) {
		fabricanteRepository.delete(fabricante);
	}
	
	public List<Fabricante> findAll() {
		return fabricanteRepository.findAll();
	}
	
	public Fabricante findId(long id) {
		
		Optional<Fabricante> objFabricante = fabricanteRepository.findById(id);
		Fabricante fab = objFabricante.get();
		
		return fab;
	}
}
