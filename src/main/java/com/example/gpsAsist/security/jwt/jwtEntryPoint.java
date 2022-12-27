package com.example.gpsAsist.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class jwtEntryPoint  implements AuthenticationEntryPoint{
	
	private final static Logger logger = LoggerFactory.getLogger(jwtEntryPoint.class); 

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Falla en el metodo Comment");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Respuesta no Autorizada");
		
		
		
	}

}
