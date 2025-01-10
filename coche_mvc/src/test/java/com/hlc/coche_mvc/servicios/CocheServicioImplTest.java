package com.hlc.coche_mvc.servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.repositorios.CocheRepositorio;

class CocheServicioImplTest {

	@Mock
	private CocheRepositorio cocheRepositorio;
	
	@InjectMocks 
	private CocheServicioImpl cocheServicio;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void obtenerTodosLosCoches() {
		List<Coche> coches = Arrays.asList(new Coche("Toyota", "1234AC", "Rojo"),new Coche("Toyota", "1234AC", "Rojo"));
		
		when(cocheRepositorio.findAll()).thenReturn(coches);
		
		//Llamar al servicio
		List<Coche> coches_servicio = cocheServicio.obtenerTodosLosCoches();
		Integer resultadoEsperado = 2;
		Integer resultado = coches_servicio.size();
		
		assertEquals(resultadoEsperado, resultado,"Debe de devolver 2 coches");
		
		verify(cocheRepositorio,times(1)).findAll();
	}

}
