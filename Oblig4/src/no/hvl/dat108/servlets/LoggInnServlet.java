package no.hvl.dat108.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.hjelpeklasser.Validation;


@WebServlet(name = "LogginnServlet", urlPatterns = { "/logginn" })
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Validation val = new Validation();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String melding = (String) request.getSession().getAttribute("melding");	
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		mobil = val.escapeHtml(mobil);
		passord = val.escapeHtml(passord);
		
		if(val.erGyldigMobil(mobil)) {
			//Sjekker om mobil finnes i database og krypterer passord dersom ja
		}
		//TODO hente kryptert passord fra database
		if(InnloggingUtil.isGyldigPassord(passord, "pass")) {
			InnloggingUtil.loggInnMedTimeout(request, 120);
			response.sendRedirect("deltagerliste");
		} else {
			String feilmelding = "Ugyldig brukernavn og/eller passord";
			request.getSession().setAttribute("melding", feilmelding);
			response.sendRedirect("logginn");
		}
	}
}
