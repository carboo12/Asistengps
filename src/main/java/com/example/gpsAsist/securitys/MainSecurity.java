package com.example.gpsAsist.securitys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.gpsAsist.security.jwt.jwtEntryPoint;
import com.example.gpsAsist.security.jwt.jwtTokenFilter;
import com.example.gpsAsist.security.services.UsuarioDetailServiceImp;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfiguration {

	@Autowired
	UsuarioDetailServiceImp usuarioDetailServiceImp;
	@Autowired
	jwtEntryPoint entryPoint;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authz) -> authz
						.anyRequest().authenticated())
				.httpBasic(withDefaults());
		return http.build();
	}

	private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
		return null;
	}

	public jwtTokenFilter tokenFilter() {
		return new jwtTokenFilter();
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
