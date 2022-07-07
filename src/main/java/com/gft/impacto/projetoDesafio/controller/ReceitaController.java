package com.gft.impacto.projetoDesafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.impacto.projetoDesafio.entidades.AuxItens;
import com.gft.impacto.projetoDesafio.entidades.Receita;
import com.gft.impacto.projetoDesafio.service.AuxItensService;
import com.gft.impacto.projetoDesafio.service.IngredientesService;
import com.gft.impacto.projetoDesafio.service.ReceitaService;
import com.gft.impacto.projetoDesafio.service.UnidadeService;

@Controller
@RequestMapping("receita")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;

	@Autowired
	private IngredientesService ingrediente;

	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private AuxItensService auxItensService;

	@RequestMapping(path = "editar")
	public ModelAndView novaReceita(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("receita/form.html");
		Receita receita;
		AuxItens auxItens;

		if (id == null) {
			receita = new Receita();
			auxItens = new AuxItens();
			} else {
			try {
				receita = receitaService.obterReceita(id);
				auxItens = auxItensService.obterAux(id);
			} catch (Exception e) {
				receita = new Receita();
				auxItens = new AuxItens();
				mv.addObject("mensagem", e.getMessage());
				// TODO: handle exception
			}
		}

		mv.addObject("receita", receita);
		mv.addObject("itens", auxItens);	
		mv.addObject("listarIngredientes", ingrediente.listarIngredientes());
		mv.addObject("listarUnidade", unidadeService.listaDasUnidades());

		return mv;
	}
	

	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvaReceita (@Valid Receita receita, BindingResult bindingResult){
	
		ModelAndView mv = new ModelAndView("receita/form.html");
		
		boolean novo = true;
		
		if (receita.getId() != null) {
			novo = false;
		}
		
		if (bindingResult.hasErrors()) {
			mv.addObject("receita", receita);
			return mv;
		}
		
		receitaService.salvarReceita(receita);
		
		if (novo) {
			mv.addObject("receita", new Receita());
		}else {
			mv.addObject("receita", receita);
		}
		
		mv.addObject("mensagem", "salvar com sucesso");
		mv.addObject("listarIngredientes", ingrediente.listarIngredientes());
		mv.addObject("listarUnidade", unidadeService.listaDasUnidades());
		 	
		return mv;
	}
	
	
	
	
}
