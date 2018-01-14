package br.com.carros.carrosapi.dao.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.carros.carrosapi.dao.VeiculoDAO;
import br.com.carros.carrosapi.dao.repository.jpa.VeiculoJpa;
import br.com.carros.carrosapi.dao.repository.jpa.VeiculoRepository;
import br.com.carros.carrosapi.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VeiculoDAOJpa implements VeiculoDAO {

	@Autowired
	private VeiculoRepository jpaRepo;

	@Override
	public List<Veiculo> buscarTodos() {
		return new ArrayList<>(jpaRepo.findAll());
	}

	@Override
	public Veiculo buscarPor(Long codigo) {
		return jpaRepo.findOne(codigo);
	}

	@Override
	public Veiculo salvar(Veiculo veiculo) {
		return jpaRepo.save(new VeiculoJpa(veiculo));
	}

	@Override
	public void apagar(Long codigo) {
		jpaRepo.delete(codigo);
	}
}
