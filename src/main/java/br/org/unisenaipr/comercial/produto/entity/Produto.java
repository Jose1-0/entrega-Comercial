package br.org.unisenaipr.comercial.produto.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Produto {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
	 	@Column(name = "produto_id", nullable = false)
	    private Long id;
	 	
	 	@Column(name = "produto_nome", nullable = false, length = 200)
	    private String nome;
	 	
		@Column(name = "produto_descricao", nullable = false, length = 200)	 	
	    private String descricao;
		
		@Column(name = "precoCusto_produto", nullable = false, length = 200)
	    private Double precoCusto;
		
		@Column(name = "precoVenda_produto", nullable = false, length = 200)
	    private Double precoVenda;
		
		@Column(name = "precoVenda", nullable = false, length = 6)
	    private Double peso;
		
		@Column(name = "quantidadeComprado_produto", nullable = false, length = 5)
	    private Integer quantidadeComprado;
		
		@Column(name = "quantidadeVendida_produto", nullable = false, length = 5)
	    private Integer quantidadeVendida;
		
		@Column(name = "quantidadeEstoque_produto", nullable = false, length = 5)
	    private Integer quantidadeEstoque;
		
		
	    private String fabricante;
	    private String grupo;
	    private String subgrupo;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    public Double getPrecoCusto() {
	        return precoCusto;
	    }

	    public void setPrecoCusto(Double precoCusto) {
	        this.precoCusto = precoCusto;
	    }

	    public Double getPrecoVenda() {
	        return precoVenda;
	    }

	    public void setPrecoVenda(Double precoVenda) {
	        this.precoVenda = precoVenda;
	    }

	    public Double getPeso() {
	        return peso;
	    }

	    public void setPeso(Double peso) {
	        this.peso = peso;
	    }

	    public Integer getQuantidadeComprado() {
	        return quantidadeComprado;
	    }

	    public void setQuantidadeComprado(Integer quantidadeComprado) {
	        this.quantidadeComprado = quantidadeComprado;
	    }

	    public Integer getQuantidadeVendida() {
	        return quantidadeVendida;
	    }

	    public void setQuantidadeVendida(Integer quantidadeVendida) {
	        this.quantidadeVendida = quantidadeVendida;
	    }

	    public String getFabricante() {
	        return fabricante;
	    }

	    public void setFabricante(String fabricante) {
	        this.fabricante = fabricante;
	    }

	    public String getGrupo() {
	        return grupo;
	    }

	    public void setGrupo(String grupo) {
	        this.grupo = grupo;
	    }

	    public String getSubgrupo() {
	        return subgrupo;
	    }

	    public void setSubgrupo(String subgrupo) {
	        this.subgrupo = subgrupo;
	    }

		public Integer getQuantidadeEstoque() {
			return quantidadeEstoque;
		}

		public void setQuantidadeEstoque(Integer quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
		}
	    
	    
}
