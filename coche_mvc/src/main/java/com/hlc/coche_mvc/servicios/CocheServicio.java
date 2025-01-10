package com.hlc.coche_mvc.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.repositorios.CocheRepositorio;

public class CocheServicio {
	@Autowired
	private CocheRepositorio cocheRepositorio;
	
	public Iterable<Coche> listarTodosLosProductos(){
		return cocheRepositorio.findAll();
	}
	
	public Coche guardarCoche(Coche producto) {
		return cocheRepositorio.save(producto);
	}
	
	public Coche obtenerPorId(Long id) {
		return cocheRepositorio.findById(id).orElseThrow();
	}
	
	public void eliminarCoche(Long id) {
        cocheRepositorio.deleteById(id);
    }
}
