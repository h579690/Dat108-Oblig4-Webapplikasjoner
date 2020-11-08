package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.*;
import no.hvl.dat108.model.DeltagerEAO;

@WebServlet(name = "PaameldingsServlet", urlPatterns = { "/paamelding" })
public class PaameldingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Validation val = new Validation();
	private DeltagerForm deltagerForm = new DeltagerForm();
//	private PassordUtil passordUtil = new PassordUtil();
	
	@EJB
	private DeltagerEAO deltagerEAO = new DeltagerEAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fnavn = request.getParameter("fornavn");
		String enavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String pass = request.getParameter("passord");
		String passRep = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");

		boolean paameldt = false;
		if(deltagerEAO.finnEnDeltager(mobil) != null) {
			paameldt = true;
			// Skal komme databasekode her
		}
		
		boolean gFnavn = false; 
		boolean	gEnavn = false;
		boolean gMobil = false;
		boolean gPass = false; 
		boolean gPassRep = false; 
		boolean gKjonn = false;

		if (!val.erGyldigNavn(fnavn)) {
			deltagerForm.setFornavnMelding("Ugyldig fornavn");
		} else {
			deltagerForm.setFornavn(fnavn);
			gFnavn = true;
		}

		if (!val.erGyldigNavn(enavn)) {
			deltagerForm.setEtternavnMelding("Ugyldig etternavn");
		} else {
			deltagerForm.setEtternavn(enavn);
			gEnavn = true;
		}

		if (!val.erGyldigMobil(mobil)) {
			deltagerForm.setMobilMelding("Ugyldig Mobil");
		} else {
			deltagerForm.setMobil(mobil);
			gMobil = true;
		}

		if (!val.erGyldigPassord(pass)) {
			deltagerForm.setPassordMelding("Ugyldig Passord");
		} else {
			gPass = true;
		}

		if (!val.erGyldigPassordRepetert(pass, passRep)) {
			deltagerForm.setPassordRepetertMelding("Ikke likt passord");
		} else {
			gPassRep = true;
		}

		if (!val.erGyldigKjonn(kjonn)) {
			deltagerForm.setKjonnMelding("Ugyldig kjonn");
		} else {
			deltagerForm.setKjonn(kjonn);
			gKjonn = true;
		}

		if ((gFnavn && gEnavn && gMobil && gPass && gPassRep && gKjonn && !paameldt)) {
			response.sendRedirect("bekreftelse");

			// bruke passordhash greiene
//			String hashetPassord = passordUtil.kryptertPassord(passord);
			// opprette Deltager element
//			Deltager deltager = new Deltager(mobil, fornavn, etternavn, hashetPassord, charForKjonn.kjonn(kjonn));
			
			// legge deltager inn i databasen
//			deltagerEAO.leggTilDeltager2(deltager);
			

			// Set Session-greier for deltageren
//			request.getSession().setAttribute("deltager", deltager)
			
			//Redirect til /bekreftelse
//			request.getSession().setAttribute("fornavn", fnavn);
//			request.getSession().setAttribute("etternavn", enavn);
//			request.getSession().setAttribute("mobil", mobil);
//			request.getSession().setAttribute("kjonn", kjonn);

		
		
		} else {

			request.getSession().setAttribute("deltagerForm", deltagerForm);

			response.sendRedirect("paamelding");
		}
	}
}
