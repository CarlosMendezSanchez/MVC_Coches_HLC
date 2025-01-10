package com.hlc.coche_mvc.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CocheTest {
	
	private Coche coche;
	
	@BeforeEach
	void setup() {
		coche = new Coche();
	}

	@Test
	void testSetAndGetMarca(){
		Long id = 1L;	
		coche.setId(1L);
		
		assertEquals(id, coche.getId());
	}
	
	@Test
	@DisplayName("Prueba de Getter y Setter de Marca")
	void testSetterGetterMarca() {
		String resultadoEsperado = "Toyota";
		
		coche.setMarca(resultadoEsperado);
		
		assertEquals(resultadoEsperado, coche.getMarca());
	}
	
	@Test
	@DisplayName("Prueba de Constructor con parámetros")
	void testConstructorConParametros() {
		String marca = "Toyota";
		String matricula = "12345ABC";
		String color = "Rojo";
		
		Coche coche = new Coche(marca,matricula,color);
		
		assertEquals(marca, coche.getMarca(), "La marca del constructor no coincide");
		assertEquals(matricula, coche.getMarca());
		assertEquals(color, coche.getColor());
	}
	

}
