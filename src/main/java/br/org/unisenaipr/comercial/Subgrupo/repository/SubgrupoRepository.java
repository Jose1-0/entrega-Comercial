package br.org.unisenaipr.comercial.Subgrupo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.unisenaipr.comercial.Subgrupo.entity.Subgrupo;

public interface SubgrupoRepository extends JpaRepository<Subgrupo, Long>{
	
	List<Subgrupo> findAll();
}
