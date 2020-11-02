package no.hvl.dat108.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LogginnServlet", urlPatterns = { "/logginn" })
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String melding = (String) request.getSession().getAttribute("melding");
			
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		
		/*
		String melding = "Ugyldig brukernavn eller passord";
		request.getSession().setAttribute("melding", melding);
		response.sendRedirect("logginn.html");
		*/
		response.sendRedirect("deltagerliste");
		

	}

}
