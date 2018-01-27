package br.com.carros.carrosapi.dao.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.carros.carrosapi.dao.MarcaDAO;
import br.com.carros.carrosapi.dao.repository.jpa.MarcaJpa;
import br.com.carros.carrosapi.dao.repository.jpa.MarcaRepository;
import br.com.carros.carrosapi.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarcaDAOJpa implements MarcaDAO {

    @Autowired
    private MarcaRepository jpaRepo;

    @Override
    public List<Marca> buscarTodos() {
        return new ArrayList<>(jpaRepo.findAll());
    }

    @Override
    public Marca buscarPor(long idMarca) {
        return jpaRepo.findOne(idMarca);
    }

    @Override
    public Marca salvar(Marca marca) {
        return jpaRepo.save(new MarcaJpa(marca));
    }

}
