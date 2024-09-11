package br.org.unisenaipr.comercial.grupo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	List<Grupo> findAll();
}
