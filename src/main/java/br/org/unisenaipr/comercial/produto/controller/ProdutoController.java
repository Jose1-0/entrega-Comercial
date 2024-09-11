package br.org.unisenaipr.comercial.produto.controller;

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

import br.org.unisenaipr.comercial.produto.entity.Produto;
import br.org.unisenaipr.comercial.produto.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
		@Autowired
	    private ProdutoService produtoService;

	    @GetMapping
	    public ResponseEntity<List<Produto>> listarProdutos() {
	        List<Produto> produtos = produtoService.listarProdutos();
	        return new ResponseEntity<>(produtos, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
	        Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
	        return produto.map(ResponseEntity::ok)
	                      .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
	        Produto produtoSalvo = produtoService.salvarProduto(produto);
	        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
	        produtoService.deletarProduto(id);
	        return ResponseEntity.noContent().build();
	    }
}
