package br.com.carros.carrosapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.com.carros.carrosapi.dao.MarcaDAO;
import br.com.carros.carrosapi.event.RecursoCriadoEvent;
import br.com.carros.carrosapi.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marcas")
public class MarcaResource extends BaseResource {



    @Autowired
    private MarcaDAO dao;

    @GetMapping
    public List<Marca> todos() {
        return this.dao.buscarTodos();
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Marca> porId(@PathVariable long codigo) {
        Marca marca = this.dao.buscarPor(codigo);
        if (null != marca) {
            return ResponseEntity.ok().body(marca);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@Valid @RequestBody Marca marca, HttpServletResponse response) {
        Marca marcaSalvo = this.dao.salvar(marca);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, marcaSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaSalvo);
    }
}
