package com.gft.impacto.projetoDesafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.
		 	authorizeRequests()
		 		.antMatchers("/ingrediente/editar").hasAnyRole("PG_INGREDIENTE")
		 		.antMatchers("/ingrediente").hasAnyRole("PG_LISTAINGREDIENTE")
		 		.antMatchers("/medida/editar").hasAnyRole("PG_UNIDADE")
		 		.antMatchers("/medida").hasAnyRole("PG_LISTAUNIDADE")
		 		.antMatchers("/receita2/editar").hasAnyRole("PG_RECEITA")
		 		.antMatchers("/receita2").hasAnyRole("PG_LISTARECEITA")
		 		.anyRequest()
		 		.authenticated()
		 		.and()
		 		.formLogin()
		 			.loginPage("/entrar")
		 			.permitAll()
		 			.and()
		 			.logout()
		 			.logoutSuccessUrl("/entrar?logout")
		 			.permitAll();
		 
		 	
	}
	 
	 @Override
	 @Bean
	protected UserDetailsService userDetailsService() {
	
		UserDetails user = User.withDefaultPasswordEncoder()
								.username("admin")
								.password("Gft@1234")
								.roles("PG_INGREDIENTE","PG_LISTAINGREDIENTE","PG_UNIDADE","PG_LISTAUNIDADE","PG_RECEITA","PG_LISTARECEITA")
								.build();
		
			
		
		return new InMemoryUserDetailsManager(user);
		
	}
	 



}
