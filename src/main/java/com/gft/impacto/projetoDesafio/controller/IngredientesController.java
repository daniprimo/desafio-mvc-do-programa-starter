 package com.gft.impacto.projetoDesafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.impacto.projetoDesafio.entidades.Ingredientes;
import com.gft.impacto.projetoDesafio.service.IngredientesService;

@Controller
@RequestMapping("ingrediente")
public class IngredientesController {

	@Autowired
	private IngredientesService ingredientesService;
	
	@RequestMapping(path = "editar")
	public ModelAndView novoIngrediente(@RequestParam (required = false) Long id ){
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		Ingredientes ingredientes;
		
		if(id==null)
		{
			ingredientes = new Ingredientes();
		}else {
			try {
				ingredientes = ingredientesService.obterIngredientes(id);
			} catch (Exception e) {
				ingredientes = new Ingredientes();
				mv.addObject("mensagem", e.getMessage());
;			}
		}
		
		mv.addObject("ingrediente",ingredientes);
		
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarIngrediente(@Valid Ingredientes ingredientes, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");

		boolean novo = true;
		
		if(ingredientes.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("ingrediente",ingredientes);
			return mv;
		}
			
		ingredientesService.salvarIngrediente(ingredientes);
		
		if (novo) {
			mv.addObject("ingrediente", new Ingredientes());
		}else {
			mv.addObject("ingrediente", ingredientes);
		}
		
		
		mv.addObject("mensagem", "Ingrediente salvo com sucesso");	
		
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView listarIngrediente() {
		
		ModelAndView mv = new ModelAndView("ingrediente/lista.html");
		
		mv.addObject("lista", ingredientesService.listarIngredientes());
		
		return mv;
		
	}

	
	
	@RequestMapping("/excluir")
	public ModelAndView excluirIngrediente(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/ingrediente");
		
		try {
			
			ingredientesService.excluirIngredientes(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluido com sucesso");
		}catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Ingrediente"+e.getMessage());
		}
			
		
		return mv;
	}
	

	
	
}
