package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.model.Deltager;
import no.hvl.dat108.model.DeltagerEAO;

/**
 * Servlet implementation class DeltagerListeServlet
 */
@WebServlet(name = "DeltagerListeServlet", urlPatterns = { "/deltagerliste" })
public class DeltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private List<Deltager> liste;
	
	@EJB
	private DeltagerEAO deltagerEAO = new DeltagerEAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(InnloggingUtil.isInnlogget(request)) {
			//TODO hente alle deltagere fra database
			//liste = deltagerEAO.deltagerListe();
			//System.out.println(liste);
			
			
			response.setContentType("text/plain");
			
			//TODO sortere listen
			List<Deltager> liste = deltagerEAO.deltagerListe().stream()
				      .sorted(Comparator.comparing(Deltager::getFornavn).thenComparing(Deltager::getEtternavn))
				      .collect(Collectors.toList());
				      
			
			//TODO finne innlogget bruker  vet ikke om det trengs??
			
			
			request.getSession().setAttribute("deltagerliste", liste);
			
			request.getRequestDispatcher("WEB-INF/jsp/deltagerliste.jsp").forward(request,response);
			
			
		} else {
			String feilmelding = "Det er kun registrerte deltagere som får se deltagerlisten. "
					+ "Logg inn ved å gi mobilnummer og passord";
			request.getSession().setAttribute("melding", feilmelding);
			request.getRequestDispatcher("logginn").forward(request, response);
		}
	}
}
