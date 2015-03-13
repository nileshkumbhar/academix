package com.xinov.academix.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;

public class LoggingResponseFilter
		implements Filter {

	@Override
	public void doFilter(final ServletRequest req,
						final ServletResponse res, 
						final FilterChain chain) throws IOException, ServletException { 
		
		final HttpServletRequest httpRequest = (HttpServletRequest)req;
		MDC.put("RemoteAddress", httpRequest.getRemoteAddr());
		chain.doFilter(req, res); 
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

}