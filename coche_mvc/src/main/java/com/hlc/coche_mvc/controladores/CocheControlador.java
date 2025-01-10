package com.hlc.coche_mvc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hlc.coche_mvc.entidades.Coche;
import com.hlc.coche_mvc.servicios.CocheServicio;



public class CocheControlador {
	@Autowired
	 CocheServicio CocheServicio;
	 @GetMapping("/")
	    public String listarCoches(Model model) {
	        model.addAttribute("productos", CocheServicio.listarTodosLosProductos());
	        return "index";
	    }

	    @GetMapping("/coche/nuevo")
	    public String mostrarFormularioDeNuevoCoche(Model model) {
	        Coche coche = new Coche();
	        model.addAttribute("producto", coche);
	        return "coche-form";
	    }

	    @GetMapping("/coche/editar/{id}")
	    public String mostrarFormularioDeEditarCoche(@PathVariable Long id, Model model) {
	        Coche coche = CocheServicio.obtenerPorId(id);
	        model.addAttribute("coche", coche);
	        return "coche-form"; 
	    }

	    @PostMapping("/coche")
	    public String guardarCoche(@ModelAttribute Coche coche) {
	        CocheServicio.guardarCoche(coche);
	        return "redirect:/";
	    }

	    @GetMapping("/coche/eliminar/{id}")
	    public String eliminarCoche(@PathVariable Long id) {
	        CocheServicio.eliminarCoche(id);
	        return "redirect:/";
	    }
}
