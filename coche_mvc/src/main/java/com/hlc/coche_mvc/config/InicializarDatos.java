package com.hlc.coche_mvc.config;

import org.springframework.stereotype.Component;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.repositorios.CocheRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	private CocheRepositorio cocheRepositorio;
	
	public InicializarDatos(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
		
		@PostConstruct
		public void init() {
			Coche coche1 = new Coche("Toyota","1234ABC", "Rojo");
			Coche coche2 = new Coche("Ford", "9876ZXY", "Verde");
			Coche coche3 = new Coche("Honda", "913RST", "Negro");
			
			cocheRepositorio.save(coche1);
			cocheRepositorio.save(coche2);
			cocheRepositorio.save(coche3);
		}
}
