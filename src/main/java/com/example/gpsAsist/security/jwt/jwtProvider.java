package com.example.gpsAsist.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import com.example.gpsAsist.security.modelo.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class jwtProvider  {
	
	private final static Logger logger = LoggerFactory.getLogger(jwtProvider.class); 
	
	@Value("$(jwt.secret)")
	private String secret;
	@Value("$(jwt.expiration)")
	private int exp;
	
	public String generarToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
				.setExpiration(new Date(new Date().getTime() +  exp * 1000))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();	}
	
	public String getNombreUsuarioToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validarToke(String token) {
		try {
			
		} catch (MalformedJwtException e) {
			logger.error("Token Mal Formado");
		}catch (UnsupportedJwtException e) {
			logger.error("Token No Soportado");
		}catch (ExpiredJwtException e) {
			logger.error("Token Espirado");
		}catch (IllegalArgumentException e) {
			logger.error("Token Vacio");
		}catch (SignatureException e) {
			logger.error("Fallo con la firma");
		}
		return false;
	}

}
