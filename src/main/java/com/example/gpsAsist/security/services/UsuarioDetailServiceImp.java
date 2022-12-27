package com.example.gpsAsist.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.gpsAsist.security.modelo.Usuario;
import com.example.gpsAsist.security.modelo.UsuarioPrincipal;

@Service
public class UsuarioDetailServiceImp implements UserDetailsService {
	@Autowired
	UsuarioServices usuarioServices;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioServices.getbyNombreUsario(username).get();
		return UsuarioPrincipal.build(usuario);
	}

}
