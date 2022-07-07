package com.gft.impacto.projetoDesafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.impacto.projetoDesafio.service.Receita2Service;

@Controller
public class PrincipalController {
	
	@Autowired
	private Receita2Service receita2Service;
	
	@RequestMapping(method = RequestMethod.GET,path = "/entrar")
	public String entrar() {
		
	return "entrar";
	}
	
	@RequestMapping
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index.html");
		
		mv.addObject("lista", receita2Service.ListarReceitas());
		
		return mv;
	}
	
	@RequestMapping("/sobre")
	public ModelAndView sobre() {
		
		ModelAndView mv = new ModelAndView("sobre.html");
		
		return mv;
	}
	
	
	
}
