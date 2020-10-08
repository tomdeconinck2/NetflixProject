package com.example.demo;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableZuulProxy
@EnableEurekaClient
public class SecurityServerApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("login", principal.getAttribute("login"));
	}

	@GetMapping("/username")
	public String username(@AuthenticationPrincipal OAuth2User principal) {
		System.out.println("Getting user ");
		return (principal != null && principal.getAttribute("login") != null) ? principal.getAttribute("login") : "NOT LOGGED IN";
		//return Collections.singletonMap("login", principal.getAttribute("login"));
	}
	
	
	@GetMapping("/private")
	public String privatee(@AuthenticationPrincipal OAuth2User principal) {
		return "Protected message";
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests(
				a -> a.antMatchers("/", "/error", "/webjars/**", "/login/**").permitAll()
					.antMatchers("/private").authenticated()
					//.anyRequest().authenticated())
					.anyRequest().permitAll())
				.logout(l -> l.logoutSuccessUrl("/").permitAll())
				.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
		        .csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) )
				.oauth2Login();
		// @formatter:on
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityServerApplication.class, args);
	}

}