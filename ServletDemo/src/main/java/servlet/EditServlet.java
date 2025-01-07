package servlet;

import static utility.Constants.CITY;
import static utility.Constants.EMAIL;
import static utility.Constants.FEMALE;
import static utility.Constants.GENDER;
import static utility.Constants.MALE;
import static utility.Constants.NAME;
import static utility.Constants.PHONE;
import static utility.Constants.USERNAME;

import java.io.IOException;
import java.io.PrintWriter;

import dao.CustomerDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		CustomerDatabase database = new CustomerDatabase();
		Customer customer = database.getCustomer(username);
		out.println("<html><body><h1>Edit!!</h1>");
		out.println("<form action='edit' method='post'>");
		out.println("<div>Username : <input type='text' value='"+customer.getUsername()+"' name='username' readonly='readonly'></div>");
		out.println("<div>Name : <input type='text' value='"+customer.getName()+"' name='name'></div>");
		out.println("<div>Phone : <input type='text' value='"+customer.getPhone()+"' name='phone'></div>");
		out.println("<div>Email : <input type='text' value='"+customer.getEmail()+"' name='email'></div>");
		out.println("<div>Male : <input type='radio' value='male' name='gender' ");
		if(customer.getGender().equals(MALE))
		{
			out.println("checked/></div>");
		}
		out.println("<div>Female : <input type='radio' value='male' name='gender' ");
		if(customer.getGender().equals(FEMALE))
		{
			out.println("checked/></div>");
		}
		out.println("<div>City : <select name='city'>");
		out.println("<option value='delhi'");
		if(customer.getCity().equals("delhi"))
			out.println(" selected>Delhi</option>");
		else
			out.println(">Delhi</option>");
		out.println("<option value='jaipur'");
		if(customer.getCity().equals("jaipur"))
			out.println(" selected>jaipur</option>");
		else
			out.println(">jaipur</option>");
		out.println("<option value='trivandrum'");
		if(customer.getCity().equals("trivandrum"))
			out.println(" selected>trivandrum</option>");
		else
			out.println(">trivandrum</option>");
		out.println("</select></div><button type='submit' value='Edit'>Edit</button>");
		out.println("<button  value='Cancel' (click)='location.href(\"admin\")'>Cancel</button>");
		out.println("</form></body></html");
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

		response.setContentType("text/html");
		if( (name != null&&!name.isEmpty() )&& 
				(email != null && !email.isEmpty()) && (phone != null && !phone.isEmpty() ) && 
				(!gender.isEmpty() && gender != "") 
				&& ( city != null && !city.isEmpty()))
		{
			System.out.println("if not null");
			Customer c1 = new Customer(name,phone,email,city,gender,username);

			CustomerDatabase database = new CustomerDatabase();		
			if(database.updateCustomer(c1))
			{				
				response.sendRedirect("admin");
			}
		}

	}

}
