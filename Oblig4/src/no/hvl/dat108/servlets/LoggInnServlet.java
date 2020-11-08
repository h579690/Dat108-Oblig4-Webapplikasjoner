package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.InnloggingUtil;
import no.hvl.dat108.hjelpeklasser.PassordUtil;
import no.hvl.dat108.hjelpeklasser.Validation;
import no.hvl.dat108.model.Deltager;
import no.hvl.dat108.model.DeltagerEAO;

@WebServlet(name = "LogginnServlet", urlPatterns = { "/logginn" })
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Validation val = new Validation();
	private PassordUtil passordUtil = new PassordUtil();

	@EJB
	DeltagerEAO deltagerEAO = new DeltagerEAO();
	Deltager deltager = new Deltager();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String melding = (String) request.getSession().getAttribute("melding");
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		mobil = val.escapeHtml(mobil);
		passord = val.escapeHtml(passord);
		String kryptertLagretPassord = "";
		boolean testMobil = val.erGyldigMobil(mobil);
		boolean testPassord = val.erGyldigPassord(passord);

		if (testMobil) {
			deltager = deltagerEAO.finnEnDeltager(mobil);
			if (deltager == null) {
				testMobil = false;
			} else {
				kryptertLagretPassord = deltager.getPassordhash();
				// testPassord = passordUtil.sjekkPassord(passord, kryptertLagretPassord);
				// InnloggingUtil.isGyldigPassord(passord, kryptertLagretPassord) ALTERNATIV
			}
		}
		if (testMobil && testPassord) {
			InnloggingUtil.loggInnMedTimeout(request, 120);

			request.getSession().setAttribute("innlogget", deltager);
			response.sendRedirect("deltagerliste");
		} else {
			String feilmelding = "Ugyldig brukernavn og/eller passord";
			request.getSession().setAttribute("melding", feilmelding);
			response.sendRedirect("logginn");
		}
	}
}
