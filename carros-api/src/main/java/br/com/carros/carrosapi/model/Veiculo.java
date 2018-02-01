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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Veiculo)) return false;
		if (!super.equals(o)) return false;

		Veiculo veiculo = (Veiculo) o;

		if (getModelo() != null ? !getModelo().equals(veiculo.getModelo()) : veiculo.getModelo() != null) return false;
		if (getAnoFabricacao() != null ? !getAnoFabricacao().equals(veiculo.getAnoFabricacao()) : veiculo.getAnoFabricacao() != null)
			return false;
		if (getAnoModelo() != null ? !getAnoModelo().equals(veiculo.getAnoModelo()) : veiculo.getAnoModelo() != null)
			return false;
		if (getPlaca() != null ? !getPlaca().equals(veiculo.getPlaca()) : veiculo.getPlaca() != null) return false;
		if (getCor() != null ? !getCor().equals(veiculo.getCor()) : veiculo.getCor() != null) return false;
		return getMarca() != null ? getMarca().equals(veiculo.getMarca()) : veiculo.getMarca() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
		result = 31 * result + (getAnoFabricacao() != null ? getAnoFabricacao().hashCode() : 0);
		result = 31 * result + (getAnoModelo() != null ? getAnoModelo().hashCode() : 0);
		result = 31 * result + (getPlaca() != null ? getPlaca().hashCode() : 0);
		result = 31 * result + (getCor() != null ? getCor().hashCode() : 0);
		result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
		return result;
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
