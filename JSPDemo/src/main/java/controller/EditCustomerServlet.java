package controller;

import static utility.Constants.CITY;
import static utility.Constants.DBMANAGER;
import static utility.Constants.EMAIL;
import static utility.Constants.GENDER;
import static utility.Constants.NAME;
import static utility.Constants.PHONE;
import static utility.Constants.USERNAME;
import java.io.IOException;
import java.io.PrintWriter;

import dao.CustomerDatabase;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/edit")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));
		System.out.println("username "+username);
		response.setContentType("text/html");
		if((!username.isEmpty() && username != null)){
			CustomerDatabase database = new CustomerDatabase();
			
			Customer customer = database.getCustomer(username);
			if(customer!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("editcustomer.jsp");
				request.setAttribute("customer", customer);
				rd.include(request, response);
			}
		}
		else{
			response.sendRedirect("admin.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
		String name=request.getParameter(NAME);
		String username=request.getParameter(USERNAME);
		String email=request.getParameter(EMAIL);
		String phone=request.getParameter(PHONE);
		String gender=request.getParameter(GENDER);
		String city=request.getParameter(CITY);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(city);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(username);
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));
		response.setContentType("text/html");
		if( (!name.isEmpty() || name != null)&& 
				(!!email.isEmpty() || email != null) && (!phone.isEmpty() || phone != null) && 
				(!gender.isEmpty() || gender != "") 
				&& ( city != null||!city.isEmpty()))
		{
			System.out.println("if not null");
			Customer c1 = new Customer(name,phone,email,city,gender,username);
			
			CustomerDatabase database = new CustomerDatabase();		
			if(database.updateCustomer( c1))
			{				
				System.out.println("insert true");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}
			else{
				System.out.println("insert false");
				RequestDispatcher rd = request.getRequestDispatcher("editcustomer.jsp");
				PrintWriter out = response.getWriter();
				out.println("Please contact administrator");
				rd.include(request, response);
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("editcustomer.jsp");
			request.setAttribute("error","Please fill in all details");
			rd.include(request, response);
		}
	}

}
