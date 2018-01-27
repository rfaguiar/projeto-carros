package br.com.carros.carrosapi.dao;

import java.util.List;

import br.com.carros.carrosapi.model.Marca;

public interface MarcaDAO {

    List<Marca> buscarTodos();

    Marca buscarPor(long idMarca);

    Marca salvar(Marca marca);
}
