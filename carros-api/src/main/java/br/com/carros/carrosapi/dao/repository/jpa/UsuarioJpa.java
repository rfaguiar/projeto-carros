package br.com.carros.carrosapi.dao.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.carros.carrosapi.model.Usuario;

@Entity
@Table(name = "usuario")
public class UsuarioJpa extends Usuario {

	private static final long serialVersionUID = 1L;

	public UsuarioJpa() {}

    public UsuarioJpa(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public UsuarioJpa(Usuario usuario) {
        super(usuario.getNome(), usuario.getLogin(), usuario.getSenha());
        setId(usuario.getId());
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return super.getId();
	}

	@Column(name="nome")
	public String getNome() {
		return super.getNome();
	}

	@Column(name="login")
	public String getLogin() {
		return super.getLogin();
	}

	@Column(name="senha")
	public String getSenha() {
		return super.getSenha();
	}
}
