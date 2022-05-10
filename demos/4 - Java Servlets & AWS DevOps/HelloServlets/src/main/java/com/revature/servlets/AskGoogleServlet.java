package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ask-google")
public class AskGoogleServlet extends HttpServlet{
	private static final long serialVersionUID = -6953386706057366230L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AskGoogleServlet doGet() invoked!");
		resp.sendRedirect("https://www.google.com");
	}
}
