package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("welcome do get");
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.html");
		}
		else {
			response.setContentType("text/html");
			response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
			response.setHeader("Pragma", "no-cache");//http1.0
			response.setHeader("Pragma", "0");//proxies
			PrintWriter out = response.getWriter();
			//		out.println("Welcome "+request.getParameter("username"));
			out.println("Welcome "+session.getAttribute("username"));
			out.println("<div><a href='profile'>Profile</a>");
			out.println("<div><a href='logout'>Logout</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome "+request.getParameter("username"));
		out.println("<div><a href='profile'>Profile</a>");
		out.println("<div><a href='logout'>Logout</a>");
	}

}
