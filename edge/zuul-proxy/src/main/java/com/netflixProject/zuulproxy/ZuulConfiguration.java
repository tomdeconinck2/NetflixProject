package com.netflixProject.zuulproxy;

import java.util.Collections;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@Controller
@EnableResourceServer
public class ZuulConfiguration extends ResourceServerConfigurerAdapter {


	@RequestMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("login", principal.getAttribute("login"));
	}
	
	@RequestMapping("/clientlogin")
	public String clientlogin(@AuthenticationPrincipal OAuth2User principal) {
		return "login.html";
	}


	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests(
				a -> a.antMatchers("/", "/error", "/webjars/**", "/clientlogin", "/clientlogin2", "/login/**", "/oauth2/**").permitAll()
				.anyRequest().authenticated())
				.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
				.csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
				.logout(l -> l.logoutSuccessUrl("/").permitAll()).oauth2Login();
		// @formatter:on
	}
	


}