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

import com.gft.impacto.projetoDesafio.entidades.ReceitaSemOAuxItens;
import com.gft.impacto.projetoDesafio.service.Receita2Service;

@Controller
@RequestMapping("receita2")
public class Receita2Controller {

	@Autowired
	private Receita2Service receita2Service;
	
	@RequestMapping(path = "editar")
	public ModelAndView novaReceita (@RequestParam (required = false) Long id) {
		ModelAndView mv = new ModelAndView("receita/form2.html");
		ReceitaSemOAuxItens receitaSemOAuxItens;
		
		if (id==null) {
			receitaSemOAuxItens = new ReceitaSemOAuxItens();
		}else {
			try {
				receitaSemOAuxItens = receita2Service.obterReceita(id);
			} catch (Exception e) {
				receitaSemOAuxItens = new ReceitaSemOAuxItens();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("receita2", receitaSemOAuxItens);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarReceita (@Valid ReceitaSemOAuxItens receitaSemOAuxItens, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("receita/form2.html");
		
		boolean novo = true;
		
		if (receitaSemOAuxItens.getId() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("receita2", receitaSemOAuxItens);
			return mv;
		}
		
		receita2Service.salvarReceita(receitaSemOAuxItens);
		
		if(novo) {
			mv.addObject("receita2", new ReceitaSemOAuxItens());
		}else {
			mv.addObject("receita2", receitaSemOAuxItens);
		}
		
		mv.addObject("mensagem", "Receita salva com sucesso");
		
		return mv;
		
	}
	
	@RequestMapping
	public ModelAndView listarIngrediente() {
		
		ModelAndView mv = new ModelAndView("receita/lista.html");
		
		mv.addObject("lista", receita2Service.ListarReceitas());
		
		return mv;
		
	}

	@RequestMapping("/excluir")
	public ModelAndView excluirReceita (@RequestParam Long id, RedirectAttributes redirectAttributes) {
	
		
		ModelAndView mv = new ModelAndView("redirect:/receita2");
		
		try {
			receita2Service.excluirReceita(id);
			redirectAttributes.addFlashAttribute("mensagem","Receita excluido com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir receita"+e.getMessage());
		}
		
		return mv ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
