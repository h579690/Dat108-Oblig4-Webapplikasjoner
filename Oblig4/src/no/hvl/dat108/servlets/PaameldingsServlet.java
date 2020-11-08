package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.*;
import no.hvl.dat108.model.Deltager;
import no.hvl.dat108.model.DeltagerEAO;

@WebServlet(name = "PaameldingsServlet", urlPatterns = { "/paamelding" })
public class PaameldingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Validation val = new Validation();
	private DeltagerForm deltagerForm = new DeltagerForm();
	private PassordUtil passordUtil = new PassordUtil();
	
	@EJB
	private DeltagerEAO deltagerEAO = new DeltagerEAO();
	
	private CharForKjonn charForKjonn = new CharForKjonn();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fornavn = val.escapeHtml(request.getParameter("fornavn"));
		String etternavn = val.escapeHtml(request.getParameter("etternavn"));
		String mobil = val.escapeHtml(request.getParameter("mobil"));
		String passord = val.escapeHtml(request.getParameter("passord"));
		String passordRepetert = val.escapeHtml(request.getParameter("passordRepetert"));
		String kjonn = request.getParameter("kjonn");

		boolean paameldt = deltagerEAO.finnEnDeltager(mobil) != null;
		
		boolean gFnavn = false; 
		boolean	gEnavn = false;
		boolean gMobil = false;
		boolean gPass = true; 
		boolean gPassRep = true; 
		boolean gKjonn = false;

		if (!val.erGyldigNavn(fornavn)) {
			deltagerForm.setFornavnMelding("Ugyldig fornavn");
		} else {
			deltagerForm.setFornavn(fornavn);
			gFnavn = true;
		}

		if (!val.erGyldigNavn(etternavn)) {
			deltagerForm.setEtternavnMelding("Ugyldig etternavn");
		} else {
			deltagerForm.setEtternavn(etternavn);
			gEnavn = true;
		}

		if (!val.erGyldigMobil(mobil)) {
			deltagerForm.setMobilMelding("Ugyldig Mobil");
		} else {
			deltagerForm.setMobil(mobil);
			gMobil = true;
		}

		if (!val.erGyldigPassord(passord)) {
			deltagerForm.setPassordMelding("Ugyldig Passord");
		} else {
			gPass = true;
		}

		if (!val.erGyldigPassordRepetert(passord, passordRepetert)) {
			deltagerForm.setPassordRepetertMelding("Ikke like passord");
		} else {
			gPassRep = true;
		}

		if (!val.erGyldigKjonn(kjonn)) {
			deltagerForm.setKjonn("ugyldig kjonn");
		} else {
			deltagerForm.setKjonn(kjonn);
			gKjonn = true;
		}

		if ((gFnavn && gEnavn && gMobil && gPass && gPassRep && gKjonn && !paameldt)) {
			

			// bruke passordhash greiene
			String hashetPassord = passordUtil.krypterPassord(passord);
			// opprette Deltager element
			
			Deltager deltager = new Deltager(mobil, fornavn, etternavn, hashetPassord, charForKjonn.kjonn(kjonn));
			
			// legge deltager inn i databasen
			deltagerEAO.leggTilDeltager2(deltager);
			
			request.getSession().setAttribute("fornavn", fornavn);
			request.getSession().setAttribute("etternavn", etternavn);
			request.getSession().setAttribute("mobil", mobil);
			request.getSession().setAttribute("kjonn", kjonn);
			
			request.getSession().setAttribute("innlogget", deltager);

			//Redirect til /bekreftelse
			response.sendRedirect("bekreftelse");
		
		} else {

			request.getSession().setAttribute("deltagerForm", deltagerForm);

			response.sendRedirect("paamelding");
		}
	}
}
