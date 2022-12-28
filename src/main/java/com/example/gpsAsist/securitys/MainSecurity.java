package com.example.gpsAsist.securitys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.gpsAsist.security.jwt.jwtEntryPoint;
import com.example.gpsAsist.security.jwt.jwtTokenFilter;
import com.example.gpsAsist.security.services.UsuarioDetailServiceImp;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {

	@Autowired
	UsuarioDetailServiceImp usuarioDetailServiceImp;
	@Autowired
	jwtEntryPoint entryPoint;
	
	private final static Logger logger = LoggerFactory.getLogger(jwtEntryPoint.class); 

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authz) throws Exception {
		return http.csrf().disable()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
		detailsManager.createUser(User.withUsername("Administrador")
				.password(passwordEncoder().encode("userPass"))
				.roles("ROLE_Administrador")
				.build());
		return detailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public jwtTokenFilter tokenFilter() {
		return new jwtTokenFilter();
	}

	@Bean
	public AuthenticationManager manager(HttpSecurity security) {
		try {
			return security.getSharedObject(AuthenticationManagerBuilder.class)
					.userDetailsService(userDetailsService())
					.passwordEncoder(passwordEncoder())
					.and()
					.build();
		} catch (Exception e) {
			logger.error("Error de Seguridad");
		}
		return null;
	}
}
