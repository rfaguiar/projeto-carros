package br.com.carros.carrosapi.dao.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.carros.carrosapi.model.Marca;

@Entity
@Table(name = "marca")
public class MarcaJpa extends Marca {

	private static final long serialVersionUID = 1L;


	public MarcaJpa() {}

	public MarcaJpa(String nome) {
		super(nome);
	}

	public MarcaJpa(Marca marca) {
		this(marca.getNome());
		setId(marca.getId());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Long getId() {
		return super.getId();
	}

	@Column(name="nome")
	@Override
	public String getNome() {
		return super.getNome();
	}
}
