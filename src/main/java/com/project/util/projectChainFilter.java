package com.project.util;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = {"/scripts/writeForm.scripts" , "/scripts/listForm.scripts","/scripts/content.scripts"})
public class projectChainFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
