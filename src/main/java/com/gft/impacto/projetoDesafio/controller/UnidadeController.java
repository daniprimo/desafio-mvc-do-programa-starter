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

import com.gft.impacto.projetoDesafio.entidades.UnidadeDeMedida;
import com.gft.impacto.projetoDesafio.service.UnidadeService;

@Controller
@RequestMapping("medida")
public class UnidadeController {

	@Autowired
	private UnidadeService unidadeService;
	
	@RequestMapping(path = "editar")
	public ModelAndView novaUnidade(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("medida/form.html");
		UnidadeDeMedida unidadeDeMedida;
		
		if(id==null) {
			unidadeDeMedida = new UnidadeDeMedida();
		}else {
			try {
				unidadeDeMedida = unidadeService.obterUnidade(id);
			}catch (Exception e) {
				unidadeDeMedida = new UnidadeDeMedida();
				mv.addObject("mensagem", e.getStackTrace());
			}
		}
		
		mv.addObject("medida", unidadeDeMedida);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarUnidade(@Valid UnidadeDeMedida unidadeDeMedida, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("medida/form.html");
		
		boolean novo = true;
		
		if(unidadeDeMedida.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("medida", unidadeDeMedida);
			return mv;
		}
		
		unidadeService.inserirNoBanco(unidadeDeMedida);
		
		if(novo) {
			mv.addObject("medida", new UnidadeDeMedida());
		}else {
			mv.addObject("medida", unidadeDeMedida);
		}
		
		
		mv.addObject("mensagem", "Unidade salvo com sucesso");
		
		return mv;
	}
	
	
	@RequestMapping
	public ModelAndView listarUnidades() {
		 ModelAndView mv = new ModelAndView("medida/lista.html");
		 
		 mv.addObject("lista", unidadeService.listaDasUnidades());
		 
		 return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirUnidade (@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/medida");
		
		try {
			
			unidadeService.excluirUnidade(id);
			redirectAttributes.addFlashAttribute("mensagem", "Unidade excluido com sucesso");
		}catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Unidade "+e.getMessage());
		}
			
		
		return mv;
	}

	
}
