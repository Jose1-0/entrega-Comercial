package br.org.unisenaipr.comercial.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.unisenaipr.comercial.produto.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findAll();
}
