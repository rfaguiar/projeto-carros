package br.com.carros.carrosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carros.carrosapi.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
