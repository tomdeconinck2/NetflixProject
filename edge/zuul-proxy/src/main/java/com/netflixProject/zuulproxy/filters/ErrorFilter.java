package com.netflixProject.zuulproxy.filters;

import com.netflix.zuul.ZuulFilter;

/*
 * For now this is a dummy implementation and has NO functionality yet
 */
public class ErrorFilter extends ZuulFilter{
	@Override
	  public String filterType() {
	    return "error";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 4;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  /*
	   * Just prints that we go can go through this filter
	   * No extra functionality is provided yet
	   */
	  @Override
	  public Object run() {
	   System.out.println("Inside Error Filter");
	 
	    return null;
	  }

}
