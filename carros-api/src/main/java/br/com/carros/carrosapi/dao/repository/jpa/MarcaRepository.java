package br.com.carros.carrosapi.dao.repository.jpa;

import br.com.carros.carrosapi.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<MarcaJpa, Long> {
}
