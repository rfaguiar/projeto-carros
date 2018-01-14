package br.com.carros.carrosapi.model;

import javax.validation.constraints.NotNull;

public class Veiculo extends Base {

	private static final long serialVersionUID = 1L;
	
	private String modelo;
	private String anoFabricacao;
	private String anoModelo;
	private String placa;
	private String cor;
	
	@NotNull
	private Marca marca;
	
	public Veiculo() {}
	
	public Veiculo(String modelo, String anoFabricacao, String anoModelo, String placa, String cor, Marca marca) {
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
	}
		
	
	@Override
	public String toString() {
		return "Veiculo [" + super.toString() + "modelo=" + modelo + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo
				+ ", placa=" + placa + ", cor=" + cor +", marca=" + marca + "]";
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
