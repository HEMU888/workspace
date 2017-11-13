package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.server.SDDocument;

/**
 * Servlet implementation class ListAllStudentsList
 */
@WebServlet("/listAllStudentsListServlet")
public class ListAllStudentsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao sd = new StudentDao();
		List<Student> listStudents = sd.getAll();
		
		request.setAttribute("students", listStudents);
		request.getRequestDispatcher("/student.jsp").forward(request, response);
	}

}
