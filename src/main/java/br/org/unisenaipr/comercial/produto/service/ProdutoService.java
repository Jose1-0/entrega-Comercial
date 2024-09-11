package br.org.unisenaipr.comercial.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.produto.entity.Produto;
import br.org.unisenaipr.comercial.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	 @Autowired
	    private ProdutoRepository produtoRepository;

	    public List<Produto> listarProdutos() {
	        return produtoRepository.findAll();
	    }

	    public Optional<Produto> buscarProdutoPorId(Long id) {
	        return produtoRepository.findById(id);
	    }

	    public Produto salvarProduto(Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    public void deletarProduto(Long id) {
	        produtoRepository.deleteById(id);
	    }
}
