package no.hvl.dat108.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;


@WebServlet(name = "FerdigServlet", urlPatterns = { "/loggut" })
public class FerdigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/ferdig.jsp").forward(request,response);
		} else {
			String feilmelding = "Det er kun registrerte deltagere som får se utlogginssiden. "
					+ "Logg inn ved å gi mobilnummer og passord";
			request.getSession().setAttribute("melding", feilmelding);
			request.getRequestDispatcher("logginn").forward(request, response);
		}
	}



}
