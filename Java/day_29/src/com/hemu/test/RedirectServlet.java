package com.hemu.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet(name = "redirectServlet", urlPatterns = { "/redirectServlet" })
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "xyz");
		System.out.println("Redirect's attr" + request.getAttribute("name"));
		
		System.out.println("Redirect's doGet");
		String location = "testServlet";
		response.sendRedirect(location);
	}

}
