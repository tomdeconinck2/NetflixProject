package com.NetflixProject.test.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
	
	@Value("${msg:Config Server is not working. Please check...}")
    private String msg;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @GetMapping()
    public String getMsg() {
    	logger.info("sleuth test");
        return this.msg;
    }
	

}
