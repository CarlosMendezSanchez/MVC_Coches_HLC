package com.hlc.coche_mvc.servicios;

import java.util.List;

import com.hlc.coche_mvc.entidades.Coche;

public interface CocheServicio {
	List<Coche> obtenerTodosLosCoches();
	Coche obtenerCochePorId(Long id);
	Coche guarCoche(Coche coche);
	void eliminarCoche(Long id);
}
