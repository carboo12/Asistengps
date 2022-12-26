package com.example.gpsAsist.security.modelo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UsuarioPrincipal implements UserDetails {
	private String nombreUser;
	private String contraseña;
	private String nombreCompleto;
	private Collection<? extends GrantedAuthority> Authorities;

	public UsuarioPrincipal(String nombreUser, String contraseña, String nombreCompleto,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombreUser = nombreUser;
		this.contraseña = contraseña;
		this.nombreCompleto = nombreCompleto;
		Authorities = authorities;
	}

	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getTipousuarioList().stream()
				.map(tipousuario -> new SimpleGrantedAuthority(tipousuario.getTipo())).collect(Collectors.toList());
		return new UsuarioPrincipal(usuario.getNombreUser(), usuario.getContraseña(), usuario.getNombreCompleto(),
				authorities);

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contraseña;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUser;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

}
