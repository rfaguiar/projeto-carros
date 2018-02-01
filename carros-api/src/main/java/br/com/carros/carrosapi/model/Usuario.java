package br.com.carros.carrosapi.model;

public class Usuario extends Base {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [" + super.toString() + "nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario)) return false;
		if (!super.equals(o)) return false;

		Usuario usuario = (Usuario) o;

		if (getNome() != null ? !getNome().equals(usuario.getNome()) : usuario.getNome() != null) return false;
		if (getLogin() != null ? !getLogin().equals(usuario.getLogin()) : usuario.getLogin() != null) return false;
		return getSenha() != null ? getSenha().equals(usuario.getSenha()) : usuario.getSenha() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
		result = 31 * result + (getLogin() != null ? getLogin().hashCode() : 0);
		result = 31 * result + (getSenha() != null ? getSenha().hashCode() : 0);
		return result;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
