package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.CustomerDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/delete")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username "+username);
		response.setContentType("text/html");
		if((!username.isEmpty() && username != null)){
			CustomerDatabase database = new CustomerDatabase();
			
			if(database.delete(username))
			{
				response.sendRedirect("admin.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				PrintWriter out = response.getWriter();
				out.println("COuld not delete");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
