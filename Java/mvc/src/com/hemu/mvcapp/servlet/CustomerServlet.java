package com.hemu.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemu.mvcapp.dao.CriteriaCustomer;
import com.hemu.mvcapp.dao.CustomerDAO;
import com.hemu.mvcapp.dao.impl.CustomerDAOImpl;
import com.hemu.mvcapp.domain.Customer;
import com.sun.xml.internal.bind.v2.model.core.ID;



/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet(urlPatterns = {"*.do"})
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
	} 

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("customerServlet: save");
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String Strid = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(Strid);
			customerDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("query.do");
		System.out.println("customerServlet: delete");
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String oldName = request.getParameter("oldName");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		if (!oldName.equalsIgnoreCase(name)) {
			long count = customerDAO.getCountWithName(name);
			if(count > 0) {
				request.setAttribute("message", "用户名"+name+"已经被占用，请重新选择");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id));
		
		customerDAO.update(customer);
		response.sendRedirect("query.do");
		
		System.out.println("customerServlet: update");
		 
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String forwardPath = "/error.jsp";
		String idStr = request.getParameter("id");
		int id = -1;
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if (customer != null) {
				forwardPath = "/updatecustomer.jsp";
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
		System.out.println("customerServlet: edit");
		 
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		long count = customerDAO.getCountWithName(name);
		if(count > 0) {
			request.setAttribute("message", "用户名"+name+"已经被占用，请重新输入");
			request.getRequestDispatcher("/newCustomer.jsp").forward(request, response);
			return ;
		}
		
		Customer customer = new Customer(name, address, phone);
		customerDAO.save(customer);
		
		response.sendRedirect("success.jsp");
		
		System.out.println("customerServlet: add");
		
	}
	
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		System.out.println("customerServlet: query");
		
	}

}
