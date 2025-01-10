package com.hlc.coche_mvc.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.repositorios.CocheRepositorio;

@Service
public class CocheServicioImpl implements CocheServicio{
	
	private CocheRepositorio cocheRepositorio;
	
	public CocheServicioImpl(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}

	@Override
	public List<Coche> obtenerTodosLosCoches() {
		return cocheRepositorio.findAll();
	}

	@Override
	public Coche obtenerCochePorId(Long id) {
		return cocheRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Coche no encontrado por Id" + id));
	}

	@Override
	public Coche guarCoche(Coche coche) {
		return cocheRepositorio.save(coche);
	}

	@Override
	public void eliminarCoche(Long id) {
		cocheRepositorio.deleteById(id);	
	}

}
