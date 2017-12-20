package br.com.carros.carrosapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public Marca() {}
	
	public Marca(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Marca ["+ super.toString() +"nome=" + nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
