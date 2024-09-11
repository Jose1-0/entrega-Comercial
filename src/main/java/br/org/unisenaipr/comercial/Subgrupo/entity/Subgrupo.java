package br.org.unisenaipr.comercial.Subgrupo.entity;

import org.springframework.data.annotation.Id;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Subgrupo {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private String descricao;

	    @ManyToOne
	    private Grupo grupo;
	    
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

	    public Grupo getGrupo() {
	        return grupo;
	    }

	    public void setGrupo(Grupo grupo) {
	        this.grupo = grupo;
	    }	
	
}
