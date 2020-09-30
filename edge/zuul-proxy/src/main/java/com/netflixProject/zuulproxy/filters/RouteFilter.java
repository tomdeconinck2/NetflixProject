package com.netflixProject.zuulproxy.filters;

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
	 
	  
	  /*
	   * Just prints that we go through this filter
	   * No extra functionality is provided yet
	   */
	  @Override
	  public Object run() {
	   System.out.println("Inside Route Filter");
	    return null;
	  }

}
