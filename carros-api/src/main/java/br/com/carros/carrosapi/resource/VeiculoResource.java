package br.com.carros.carrosapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carros.carrosapi.dao.VeiculoDAO;
import br.com.carros.carrosapi.event.RecursoCriadoEvent;
import br.com.carros.carrosapi.model.Veiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResource extends BaseResource {

	@Autowired
	private VeiculoDAO service;

	@GetMapping
	public List<Veiculo> todos() {
		return this.service.buscarTodos();
	}
	
	@GetMapping(path="/{codigo}")
	public ResponseEntity<Veiculo> porId(@PathVariable Long codigo) {
		Veiculo veiculo = this.service.buscarPor(codigo);
		if (veiculo != null) {
			return ResponseEntity.ok().body(veiculo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> criar(@Valid @RequestBody Veiculo veiculo, HttpServletResponse response) {
		Veiculo veiculoSalvo = this.service.salvar(veiculo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, veiculoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
	}
	
	@DeleteMapping(path="/{codigo}")
	public ResponseEntity<Void> delete (@PathVariable Long codigo) {
		this.service.apagar(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
