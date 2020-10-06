package com.netflixProject.zuulproxy.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;



/*
 * For now this is a dummy implementation and has NO functionality yet
 */
public class PreFilter extends ZuulFilter{

	@Override
	  public String filterType() {
	    return "pre";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 0;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  /*
	   * Just prints the type of request to show we go through this filter
	   * No extra functionality is provided yet
	   */
	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	 
	    System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
	    return null;
	  }
}
