package com.example.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
    @GetMapping("/")
    public String home(@AuthenticationPrincipal OAuth2User principal) {
        return "index.html";
    }
    
	@GetMapping("/login")
	public String login(@AuthenticationPrincipal OAuth2User principal) {
		return "login.html";
	}
}
