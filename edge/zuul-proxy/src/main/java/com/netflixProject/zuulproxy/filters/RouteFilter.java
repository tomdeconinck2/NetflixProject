package com.netflixProject.zuulproxy.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import com.netflix.zuul.ZuulFilter;


/*
 * For now this is a dummy implementation and has NO functionality yet
 */
public class RouteFilter extends ZuulFilter{
	@Override
	  public String filterType() {
	    return "route";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 1;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  @Autowired
	  private DiscoveryClient discoveryClient;
	  
	  
	  /*
	   * Just prints that we go through this filter
	   * No extra functionality is provided yet
	   */
	  @Override
	  public Object run() {
	   System.out.println("Inside Route Filter");
	   
		List<ServiceInstance> instances = discoveryClient.getInstances("TEST");
		ServiceInstance si = instances.get(0);
		String baseUrl = si.getUri().toString();
		
		//System.out.println(si);
	    //System.out.println(baseUrl);
		return null;
	  }

}


