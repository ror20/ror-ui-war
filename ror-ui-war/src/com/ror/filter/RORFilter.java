package com.ror.filter;

import static com.ror.constants.RORConstants.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RORFilter
 */
public class RORFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RORFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("Inside filter..");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String active = (String) session.getAttribute(ACTIVE);
		
		System.out.println("Value of Session active:" + active);
		if (active != null) {
			if (active.equals(NO) && !req.getRequestURL().toString().contains(AUTHENTICATE)) {
				session.invalidate();
				req.getRequestDispatcher(INDEX_JSP).forward(req, response);
			}

		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
