package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dao.CustomerDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Customer> customers = new ArrayList<>();
		CustomerDatabase database = new CustomerDatabase();
		customers = database.getCustomers();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><style>table {border-spacing: 15px;border-bottom: "
				+ "1px scrollbar solid;border-collapse: collapse;}"
				+"th, td {border: 1px solid black;text-align: center;padding: 35px;}"
				+ "body{margin:30px;background-color: bisque;}</style></head><body>");
		out.println("<table><tr><th>Name</th><th>City</th><th>Phone</th><th>Gender</th>"
				+ "<th>Email</th></tr>");
		for (Customer c : customers) {
			out.println("<tr><td>"+c.getName()+"</td>");
			out.println("<td>"+c.getCity()+"</td>");
			out.println("<td>"+c.getPhone()+"</td>");
			out.println("<td>"+c.getGender()+"</td>");
			out.println("<td>"+c.getEmail()+"</td>");
			out.println("<td><a href='edit?username="+c.getUsername()+"'>Edit</a></td>");
			out.println("<td><a href='delete?username="+c.getUsername()+"'>Delete</a></td></tr>");	
			
		}
		out.println("</table>");
		out.println("<div><a href='logout'>Logout</a>");
		out.println("</body></html");
	}


}
