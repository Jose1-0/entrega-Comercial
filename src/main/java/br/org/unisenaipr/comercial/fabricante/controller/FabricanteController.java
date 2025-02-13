package br.org.unisenaipr.comercial.fabricante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.unisenaipr.comercial.fabricante.entity.Fabricante;
import br.org.unisenaipr.comercial.fabricante.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	

	public FabricanteController(FabricanteService fabricanteService) {
		this.fabricanteService = fabricanteService;
	}
	
	@GetMapping("/fabricanteIndex")
	public String fabricanteIndex(Model theModel) {
		
		List<Fabricante> list = fabricanteService.findAll();
		
		theModel.addAttribute("fabricante", list);
		
		return "fabricante/list";
	}

	@PostMapping("/fabricanteSave")
	public String fabricanteSave(Model theModel) {
		
		Fabricante fabricante = new Fabricante();
		
		theModel.addAttribute("fabricante", fabricante);
		
		return "fabricante/cadastro";
	}
	
	@PostMapping("/save-fabricante")
	public String saveFabricante(@ModelAttribute Fabricante fabricante) {
		
		fabricanteService.saveFabricante(fabricante);

		return "redirect:/fabricante/fabricanteIndex";
	}	

	@GetMapping("/fabricanteUpdate/{id}")
	public String fabricanteUpdate(@PathVariable long id, Model theModel) {
		
		Fabricante fabricante = new Fabricante();
		
		fabricante = fabricanteService.findId(id);
		
		theModel.addAttribute("fabricante", fabricante);
		
		return "fabricante/alterar";
	}

	@PostMapping("/alterar-fabricante/{id}")
	public String updateUser(@ModelAttribute Fabricante fabricante) {
		
		fabricanteService.updateFabricante(fabricante);
		
		return "redirect:/fabricante/fabricanteIndex";
	}	

	@GetMapping("/deletar-fabricante/{id}")
	public String deleteUser(@PathVariable long id) {
		
		Fabricante fabricante = new Fabricante();
		
		fabricante.setId(id);
		
		fabricanteService.deleteFabricante(fabricante);
		
		return "redirect:/fabricante/fabricanteIndex";
	}	
	
}
