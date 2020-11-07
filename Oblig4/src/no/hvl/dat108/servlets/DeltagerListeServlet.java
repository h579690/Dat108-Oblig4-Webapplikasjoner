package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.model.Deltager;

/**
 * Servlet implementation class DeltagerListeServlet
 */
@WebServlet(name = "DeltagerListeServlet", urlPatterns = { "/deltagerliste" })
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<Deltager> liste;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(InnloggingUtil.isInnlogget(request)) {
			//TODO hente alle deltagere fra database
			//liste = deltakerEAO.hentAlle();
			//TODO sortere listen
			//TODO finne innlogget bruker
			//request.getSession().setAttribute("deltakerliste", liste);
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request,response);
		} else {
			String feilmelding = "Det er kun registrerte deltagere som får se deltagerlisten. "
					+ "Logg inn ved å gi mobilnummer og passord";
			request.getSession().setAttribute("melding", feilmelding);
			request.getRequestDispatcher("logginn").forward(request, response);
		}
	}
}
