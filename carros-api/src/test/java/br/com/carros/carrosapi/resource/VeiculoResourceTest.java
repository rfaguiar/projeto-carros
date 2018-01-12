package br.com.carros.carrosapi.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;

import br.com.carros.carrosapi.dao.VeiculoDAO;
import br.com.carros.carrosapi.model.Marca;
import br.com.carros.carrosapi.model.Veiculo;

public class VeiculoResourceTest {
	
	@InjectMocks
	private VeiculoResource veiculoRs = new VeiculoResource();

	@Mock
	private VeiculoDAO dao;
	
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
		Veiculo veiculo = new Veiculo("palio", "2006", "2006", "XXX-9999", "preto", new Marca("fiat"));
		veiculo.setId(1l);
		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(veiculo);
		when(dao.buscarTodos()).thenReturn(veiculos);
		
		List<Veiculo> response = veiculoRs.todos();
		
		veiculo = response.get(0);

		assertEquals(1l, veiculo.getId().longValue());
		assertEquals("palio", veiculo.getModelo());
		assertEquals("2006", veiculo.getAnoFabricacao());
		assertEquals("2006", veiculo.getAnoModelo());
		assertEquals("XXX-9999", veiculo.getPlaca());
		assertEquals("preto", veiculo.getCor());
		assertEquals("fiat", veiculo.getMarca().getNome());
	}

	@Test
	public void quandoRealizarAConsultaComIdValidoDeveRetornarORegistroECodigo200() {
		Veiculo veiculo = new Veiculo("palio", "2006", "2006", "XXX-9999", "preto", new Marca("fiat"));
		veiculo.setId(1l);
		when(dao.buscarPor(anyLong())).thenReturn(veiculo);
		
		ResponseEntity<Veiculo> response = veiculoRs.porId(1l);
		
		veiculo = response.getBody();
		
		assertEquals(200, response.getStatusCodeValue());

		assertEquals(1l, veiculo.getId().longValue());
		assertEquals("palio", veiculo.getModelo());
		assertEquals("2006", veiculo.getAnoFabricacao());
		assertEquals("2006", veiculo.getAnoModelo());
		assertEquals("XXX-9999", veiculo.getPlaca());
		assertEquals("preto", veiculo.getCor());
		assertEquals("fiat", veiculo.getMarca().getNome());
	}
	
	@Test
	public void quandoRealizarAConsultaComIdInvalidoDeveRetornarnuloECodigo404() {
		when(dao.buscarPor(anyLong())).thenReturn(null);
		
		ResponseEntity<Veiculo> response = veiculoRs.porId(1l);
		
		Veiculo veiculo = response.getBody();
		
		assertEquals(404, response.getStatusCodeValue());

		assertNull(veiculo);
	}
	
	@Test
	public void quandoSalvarODeveRetornarORegistroECodigo201EHeaderLocationComLink() {
		Veiculo veiculo = new Veiculo("palio", "2006", "2006", "XXX-9999", "preto", new Marca("fiat"));
		veiculo.setId(1l);
		when(dao.salvar(veiculo)).thenReturn(veiculo);
								
		ResponseEntity<Veiculo> response = veiculoRs.criar(veiculo, httpResponse);
		
		veiculo = response.getBody();
				
		assertEquals(201, response.getStatusCodeValue());

		assertEquals(1l, veiculo.getId().longValue());
		assertEquals("palio", veiculo.getModelo());
		assertEquals("2006", veiculo.getAnoFabricacao());
		assertEquals("2006", veiculo.getAnoModelo());
		assertEquals("XXX-9999", veiculo.getPlaca());
		assertEquals("preto", veiculo.getCor());
		assertEquals("fiat", veiculo.getMarca().getNome());
	}

}
