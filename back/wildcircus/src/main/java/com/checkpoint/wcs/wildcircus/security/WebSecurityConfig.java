package com.checkpoint.wcs.wildcircus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// On désactive la protection CSRF, tout simplement parce que le token JWT 
		// fait office de jeton
		httpSecurity
				.csrf().disable() 
				.authorizeRequests(). //  on autorise tout le monde à consulter les uri suivantes: 
				antMatchers( "/authenticate").permitAll().
				antMatchers( "/register").permitAll(). // à supprimer après création d'un utilisateur.
				// toutes les autres nécessitent un token valide
				antMatchers( "/cart").permitAll().
				antMatchers( "/cart/*").permitAll().
				antMatchers("/customer").permitAll().
				antMatchers("/customer/*").permitAll().
				antMatchers( "/gallery").permitAll().
				antMatchers( "/line-cart").permitAll().
				antMatchers( "/line-cart/*").permitAll().
				antMatchers( "/line-cart-id/*").permitAll().
				antMatchers( "/send-order-email").permitAll().
				antMatchers( HttpMethod.GET, "/performance").permitAll().
				antMatchers( "/schedule").permitAll().
				antMatchers( "/ticket").permitAll().
				antMatchers( "/ticket/*").permitAll().
				antMatchers( "/ticket-period/*").permitAll().
				anyRequest().authenticated().and().
				// on s'assure d'utiliser des stateless sessions
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Ajoute un filtre servant à valider le token pour chaque requète
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}