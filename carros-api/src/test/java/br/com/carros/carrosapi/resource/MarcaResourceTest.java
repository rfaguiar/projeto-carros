package br.com.carros.carrosapi.resource;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import br.com.carros.carrosapi.dao.MarcaDAO;
import br.com.carros.carrosapi.model.Marca;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

public class MarcaResourceTest {
	
	@InjectMocks
	private MarcaResource marcaResource = new MarcaResource();

	@Mock
	private MarcaDAO dao;
	
	@Mock
	private ApplicationEventPublisher publisher;
	
	@Mock
	private HttpServletResponse httpResponse;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void quandoRealizarAConsultaDeveRetornarOsRegistrosECodigo200() {
		Marca marca = new Marca("fiat");
		marca.setId(1l);
		List<Marca> marcas = new ArrayList<>();
		marcas.add(marca);
		when(dao.buscarTodos()).thenReturn(marcas);
		
		List<Marca> response = marcaResource.todos();
		
		marca = response.get(0);

		assertEquals(1l, marca.getId().longValue());
		assertEquals("fiat", marca.getNome());
	}

	@Test
	public void quandoRealizarAConsultaComIdValidoDeveRetornarORegistroECodigo200() {
		Marca marca = new Marca("fiat");
		marca.setId(1l);
		when(dao.buscarPor(anyLong())).thenReturn(marca);
		
		ResponseEntity<Marca> response = marcaResource.porId(1l);

		marca = response.getBody();
		
		assertEquals(200, response.getStatusCodeValue());

		assertEquals(1l, marca.getId().longValue());
		assertEquals("fiat", marca.getNome());
	}

	@Test
	public void quandoRealizarAConsultaComIdInvalidoDeveRetornarnuloECodigo404() {
		when(dao.buscarPor(anyLong())).thenReturn(null);
		
		ResponseEntity<Marca> response = marcaResource.porId(1l);

		Marca marca = response.getBody();
		
		assertEquals(404, response.getStatusCodeValue());

		assertNull(marca);
	}

	@Test
	public void quandoSalvarODeveRetornarORegistroECodigo201EHeaderLocationComLink() {
		Marca marca = new Marca("fiat");
		marca.setId(1l);
		when(dao.salvar(marca)).thenReturn(marca);
								
		ResponseEntity<Marca> response = marcaResource.criar(marca, httpResponse);

		marca = response.getBody();
				
		assertEquals(201, response.getStatusCodeValue());

		assertEquals(1l, marca.getId().longValue());
		assertEquals("fiat", marca.getNome());
	}
}
