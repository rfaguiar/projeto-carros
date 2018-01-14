package br.com.carros.carrosapi.model;

public class Marca extends Base {

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
