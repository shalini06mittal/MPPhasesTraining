package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;

import dao.CustomerDatabase;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerDatabase database = new CustomerDatabase();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		Customer customer = database.getCustomer(username);

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies

		PrintWriter out = response.getWriter();

		out.println("<div>"+"<p>Name :"+ customer.getName() +"</p>"
				+"<p>Email :"+ customer.getEmail() +"</p>"
				+"<p>City :"+ customer.getCity() +"</p>"
				+"<p>Gender :"+ customer.getGender() +"</p>"
				+"<p>Phone :"+ customer.getPhone() +"</p>"
				+ "</div>");
		out.println("<div><a href='welcome'>Welcome</a>");
		out.println("<div><a href='logout'>Logout</a>");
	}

}
