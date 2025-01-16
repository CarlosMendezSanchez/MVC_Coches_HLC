package com.hlc.coche_mvc.controladores;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.assertj.core.error.ShouldHaveSameSizeAs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.servicios.CocheServicio;

@WebMvcTest(CocheControlador.class)
class cocheControladorTest {
	
	
	@Autowired
	private MockMvc mock;
	
	
	@MockitoBean
	private CocheServicio servicio;
	
	@Test
	@DisplayName("Debe listar todos los coches y la vista correcta")
	void listarCoches() throws Exception{
		when(servicio.obtenerTodosLosCoches()).thenReturn(
				Arrays.asList(
						new Coche("Toyota", "12345ABC", "Rojo"),
						new Coche("Ford", "5678DEF", "Azul")
						)
				);
		mock.perform(get("/coches")).andExpect(status().isOk()).andExpect(view().name("coches/listar"))
		.andExpect(model().attributeExists("coches"));
	}

}
