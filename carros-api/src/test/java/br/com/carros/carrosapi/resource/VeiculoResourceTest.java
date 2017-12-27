package br.com.carros.carrosapi.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.carros.carrosapi.model.Marca;
import br.com.carros.carrosapi.model.Veiculo;
import br.com.carros.carrosapi.repository.VeiculoRepository;

public class VeiculoResourceTest {
	
	@InjectMocks
	private VeiculoResource veiculoRs = new VeiculoResource();

	@Mock
	private VeiculoRepository veiculoRepo;

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
		when(veiculoRepo.findAll()).thenReturn(veiculos);
		
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
		when(veiculoRepo.findOne(anyLong())).thenReturn(veiculo);
		
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
		when(veiculoRepo.findOne(anyLong())).thenReturn(null);
		
		ResponseEntity<Veiculo> response = veiculoRs.porId(1l);
		
		Veiculo veiculo = response.getBody();
		
		assertEquals(404, response.getStatusCodeValue());

		assertNull(veiculo);
	}

}
