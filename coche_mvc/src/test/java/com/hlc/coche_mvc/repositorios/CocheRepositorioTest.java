package com.hlc.coche_mvc.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hlc.coche_mvc.entidades.Coche;

@DataJpaTest
class CocheRepositorioTest {
	
	@Autowired
	private CocheRepositorio cocheRepositorio;
	
	@Test
	void testSaveAndFindAll() {
		//Crear y guardar coches
		Coche coche1 = new Coche("Toyota", "1234ABC", "Rojo");
		Coche coche2 = new Coche("Ford", "9876ZXY", "Verde");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		
		List<Coche> coches = cocheRepositorio.findAll();
		
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, coches.size(), "Debería haber 2 coches");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Toyota")),"Deberia contener un coche Toyota");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Ford")),"Deberia contener un coche Ford");

	}
	
}
