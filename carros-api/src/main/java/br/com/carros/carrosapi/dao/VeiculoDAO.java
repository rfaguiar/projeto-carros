package br.com.carros.carrosapi.dao;

import java.util.List;

import br.com.carros.carrosapi.model.Veiculo;

public interface VeiculoDAO {

	List<Veiculo> buscarTodos();
	
	Veiculo buscarPor(Long codigo);

	Veiculo salvar(Veiculo veiculo);

	void apagar(Long codigo);
	
}
