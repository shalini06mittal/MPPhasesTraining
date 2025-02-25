package servlet;
import static utility.Constants.PASSWORD;
import static utility.Constants.USERNAME;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

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
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("login.html");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter(USERNAME);
		String password=request.getParameter(PASSWORD);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
				Login login = new Login(username, password);
				LoginDatabase database = new LoginDatabase();
				if(database.validate(login))
				{
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome");
//					dispatcher.forward(request, response);
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					Cookie cookie = new Cookie("id", "1");
					response.addCookie(cookie);
					response.sendRedirect("welcome");
				}
				else
				{
					//response.sendRedirect("login.html");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
					out.println("<p style='color:red'>Invalid Credentials</p>");
					dispatcher.include(request, response);
				}
		
	}

}
