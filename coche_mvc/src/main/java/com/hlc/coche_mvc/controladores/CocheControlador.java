package com.hlc.coche_mvc.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.servicios.CocheServicio;


@Controller
@RequestMapping("/coches")
public class CocheControlador {
	
	private final String VISTA_LISTA = "coches/listar";
	private final String VISTA_FORM = "coches/formulario";
	
	private CocheServicio servicio;
	
	public CocheControlador(CocheServicio servicio) {
		this.servicio = servicio;
	}
	
	 @GetMapping
	    public String listar(Model model) {
	        List<Coche> coches = servicio.obtenerTodosLosCoches();
	        model.addAttribute("coches", coches);
	        return "VISTA_LISTA";
	    }

	    @GetMapping("/nuevo")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("coche", new Coche());
	        return "VISTA_FORM"; 
	    }
}
