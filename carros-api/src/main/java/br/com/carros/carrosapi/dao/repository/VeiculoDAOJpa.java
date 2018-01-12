package br.com.carros.carrosapi.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carros.carrosapi.dao.VeiculoDAO;
import br.com.carros.carrosapi.model.Veiculo;

@Repository
public class VeiculoDAOJpa implements VeiculoDAO {

	@Autowired
	private JpaRepository<Veiculo, Long> jpaRepo;

	@Override
	public List<Veiculo> buscarTodos() {
		return jpaRepo.findAll();
	}

	@Override
	public Veiculo buscarPor(Long codigo) {
		return jpaRepo.findOne(codigo);
	}

	@Override
	public Veiculo salvar(Veiculo veiculo) {
		return jpaRepo.save(veiculo);
	}

	@Override
	public void apagar(Long codigo) {
		jpaRepo.delete(codigo);
	}
}
