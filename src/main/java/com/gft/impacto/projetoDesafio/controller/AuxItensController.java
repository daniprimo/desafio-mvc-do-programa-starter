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

import com.gft.impacto.projetoDesafio.entidades.AuxItens;
import com.gft.impacto.projetoDesafio.service.AuxItensService;
import com.gft.impacto.projetoDesafio.service.IngredientesService;
import com.gft.impacto.projetoDesafio.service.UnidadeService;

@Controller
@RequestMapping("auxiliar")
public class AuxItensController {
	
	@Autowired
	private AuxItensService auxItensService;

	@Autowired
	private IngredientesService ingrediente;
	
	@Autowired
	private UnidadeService unidadeService;
	
	@RequestMapping(path = "editar")
	public ModelAndView novoAux(@RequestParam (required = false) Long id ){
		
		ModelAndView mv = new ModelAndView("auxiliar/form.html");
		AuxItens auxItens;
		
		if(id==null) {
			auxItens = new AuxItens();
		}else {
			try {
				auxItens = auxItensService.obterAux(id);
			}catch (Exception e) {
				auxItens = new AuxItens();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		
		mv.addObject("auxiliar", auxItens);
		mv.addObject("listarIngredientes", ingrediente.listarIngredientes());
		mv.addObject("listarUnidade", unidadeService.listaDasUnidades());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "editar")
	public ModelAndView salvarAux(@Valid AuxItens auxItens, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("auxiliar/form.html");
		
		boolean novo = true;
		
		if(auxItensService.listarAux() != null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("auxiliar", auxItens);
			return mv;
		}
		
		auxItensService.inserirAux(auxItens);
		
		if(novo) {
			mv.addObject("auxiliar", new AuxItens());
		}else {
			mv.addObject("auxiliar", auxItens);
		}
		
		mv.addObject("mensagem", "Salvo com sucesso");
		mv.addObject("listarIngredientes", ingrediente.listarIngredientes());
		mv.addObject("listarUnidade", unidadeService.listaDasUnidades());
		
	
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listarAux() {
		
		ModelAndView mv = new ModelAndView("auxiliar/lista.html");
		
		mv.addObject("lista", auxItensService.listarAux());
		
		
		return mv;
		
	}

	
	@RequestMapping("/excluir")
	public ModelAndView excluirAux (@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/auxiliar");
		
		try {
			auxItensService.excluirAux(id);
			redirectAttributes.addFlashAttribute("mensagem", "Auxixiliar Itens excluido com sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Auxiliar Itens"+e.getMessage());

		}
		
		return mv;
	}
	


	
}
