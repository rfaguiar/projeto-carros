package br.com.carros.carrosapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carros.carrosapi.model.Veiculo;
import br.com.carros.carrosapi.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoRepository veiculoRepo;
	
	@GetMapping
	public List<Veiculo> todos() {
		return this.veiculoRepo.findAll();
	}
	
}
