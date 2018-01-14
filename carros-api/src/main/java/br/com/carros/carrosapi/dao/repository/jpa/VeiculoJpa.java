package br.com.carros.carrosapi.dao.repository.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.carros.carrosapi.model.Marca;
import br.com.carros.carrosapi.model.Veiculo;

@Entity
@Table(name = "veiculo")
public class VeiculoJpa extends Veiculo {

	private static final long serialVersionUID = 1L;
	
	public VeiculoJpa() {}
	
	public VeiculoJpa(String modelo, String anoFabricacao, String anoModelo, String placa, String cor, Marca marca) {
		super(modelo, anoFabricacao, anoModelo, placa, cor, marca);
	}

	public VeiculoJpa(Veiculo veiculo) {
		this(veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getAnoModelo(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getMarca());
		setId(veiculo.getId());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return super.getId();
	}

    @Column(name="modelo")
	public String getModelo() {
		return super.getModelo();
	}

	@Column(name = "ano_fabricacao")
	public String getAnoFabricacao() {
		return super.getAnoFabricacao();
	}
	
	@Column(name = "ano_modelo")
	public String getAnoModelo() {
		return super.getAnoModelo();
	}

	@Column(name="placa")
	public String getPlaca() {
		return super.getPlaca();
	}

    @Column(name="cor")
	public String getCor() {
		return super.getCor();
	}

	@ManyToOne
	@JoinColumn(name = "id_marca")
	public MarcaJpa getMarca() {
		return new MarcaJpa(super.getMarca());
	}

}
