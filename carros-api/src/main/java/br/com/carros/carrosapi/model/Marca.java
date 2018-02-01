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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Marca)) return false;
		if (!super.equals(o)) return false;

		Marca marca = (Marca) o;

		return getNome() != null ? getNome().equals(marca.getNome()) : marca.getNome() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
