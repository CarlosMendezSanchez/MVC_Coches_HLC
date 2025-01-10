package com.hlc.coche_mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import com.hlc.coche_mvc.servicios.CocheServicio;
import com.hlc.coche_mvc.entidades.Coche;

import jakarta.annotation.PostConstruct;

public class InicializarDatos {
	@Autowired
	private CocheServicio CocheServicio;
		
		@PostConstruct
		public void init() {
			Coche coche1 = new Coche();
			coche1.setMarca("Toyota");
			coche1.setColor("Rojo");
			coche1.setMatricula("1234ABC");
			CocheServicio.guardarCoche(coche1);
			
			Coche coche2 = new Coche();
			coche2.setMarca("Honda");
			coche2.setColor("Azul");
			coche2.setMatricula("5678DEF");
			CocheServicio.guardarCoche(coche2);
		}
}
