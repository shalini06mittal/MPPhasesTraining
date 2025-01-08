package controller;
import static utility.Constants.DBMANAGER;
import static utility.Constants.PASSWORD;
import static utility.Constants.USERNAME;

import java.io.IOException;
import java.io.PrintWriter;

import dao.LoginDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter(USERNAME);
		String password=request.getParameter(PASSWORD);
		
		response.setContentType("text/html");
		
		if((!username.isEmpty() && username != null) && (!password.isEmpty() 
				&& password != null)){
			
				Login login = new Login(username, password);
				LoginDatabase database = new LoginDatabase();
				if(database.validate(login))
				{
					System.out.println("valid");
					HttpSession session = request.getSession();
					session.setAttribute("username", login.getUsername());
					response.sendRedirect("welcome.jsp");
				}
				else
				{
					System.out.println("invalid");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					PrintWriter out = response.getWriter();
					out.println("Invalid Credentials");
					rd.include(request, response);
				}
			}
		else{

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<h4 style='color:red;margin-left:30px;'>Username or password cannot be empty</h4>");
			rd.include(request, response);
		}
	}

}
