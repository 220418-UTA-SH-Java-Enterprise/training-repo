package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	
	private static final long serialVersionUID = 967277077476365940L;

	/*
	 * Servlet lifecycle:
	 * 1) init() = when the servlet is starting up in the web container
	 * 2) doRequest() = when a servlet is processing a HTTP request
	 * 3) destroy() = when the servlet is closing or app closes
	 */
	
	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet started init() invoked!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServlet doGet() invoked!");
		System.out.println(req.getAttribute("request-state")); //will be null if req was not forwarded by another servlet
		System.out.println(this.getServletConfig().getInitParameter("someParam")); //returns someValue if redirected - see? if from TestServlet
		System.out.println(this.getServletContext().getInitParameter("contextParam")); //return contextValue from the servletContext in our web.xml
		resp.getWriter().write("<h1>/test endpoint works!!</h1>");
	}
	
	@Override
	public void destroy() {
		System.out.println("TestServlet shutting down destroy() invoked!");
	}
}
