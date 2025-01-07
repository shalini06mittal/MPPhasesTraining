package servlet;

import static utility.Constants.CITY;
import static utility.Constants.EMAIL;
import static utility.Constants.GENDER;
import static utility.Constants.NAME;
import static utility.Constants.PASSWORD;
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
import model.Customer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter(NAME);
		String username=request.getParameter(USERNAME);
		String passwrod=request.getParameter(PASSWORD);
		String email=request.getParameter(EMAIL);
		String phone=request.getParameter(PHONE);
		String gender=request.getParameter(GENDER);
		String city=request.getParameter(CITY);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if( (name != null && !name.trim().isEmpty())&& (username !=null && !username.trim().isEmpty() ) &&
				(!!email.isEmpty() || email != null) && (!phone.isEmpty() && phone != null) && 
				(!gender.isEmpty() || gender != "") && (!city.isEmpty() || city != null))
		{
			System.out.println("if not null");
		
			Customer c1 = new Customer(name,phone,email,city,gender,username,passwrod);
			System.out.println(c1);
			CustomerDatabase database = new CustomerDatabase();		
			if(database.insert(c1))
			{				
				System.out.println("insert true");
				out.println("Successfully Registered. Please Login");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			else{
				System.out.println("insert false");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				
				out.println("Please contact administrator");
				rd.include(request, response);
			}
		}
		else{
			out.println("Fill in all details");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");			
			rd.include(request, response);
		}
	}

}
