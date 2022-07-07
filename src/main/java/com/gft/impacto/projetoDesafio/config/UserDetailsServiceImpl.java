package com.gft.impacto.projetoDesafio.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.gft.impacto.projetoDesafio.entidades.Usuario;
import com.gft.impacto.projetoDesafio.repository.UsuarioRepository;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(authority);
			User user = new User(usuario.getUserName(), usuario.getSenha(), authorities);
			return user;
		}
		return null;
	}

	
	
}
