package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.hjelpeklasser.*;


@WebServlet(name = "PaameldingsServlet", urlPatterns = { "/paamelding" })
public class PaameldingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Validation val = new Validation(); 
	private DeltagerForm deltagerForm = new DeltagerForm();

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   deltagerForm.getFornavn();
	   deltagerForm.getEtternavn();
	   deltagerForm.getMobil();
	   deltagerForm.getKjonn();
	   deltagerForm.getFornavnMelding();
	   deltagerForm.getEtternavnMelding();
	   deltagerForm.getMobilMelding();
	   deltagerForm.getPassordMelding();
	   deltagerForm.getPassordRepetertMelding();
	   deltagerForm.getKjonnMelding();
		
		System.out.println(deltagerForm.getFornavn());
		
	   request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fnavn = request.getParameter("fornavn");
		String enavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String pass = request.getParameter("passord");
		String passRep = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
		
		
		boolean paameldt = false; // Skal komme databasekode her
		boolean gFnavn = false ,
				gEnavn = false,
				gMobil = false, 
				gPass = false,
				gPassRep = false, 
				gKjonn = false;
		
	
	   		if(!val.erGyldigNavn(fnavn) ) {
	   			deltagerForm.setFornavnMelding("Ugyldig fornavn");
	   		}else {
	   			deltagerForm.setFornavn(fnavn);
	   			gFnavn = true;
	   		}
	   		
	   		if(!val.erGyldigNavn(enavn)) {
	   			deltagerForm.setEtternavnMelding("Ugyldig etternavn");
	   		}else {
	   			deltagerForm.setEtternavn(enavn);
	   			gEnavn = true;
	   		}
	   		
	   		if(!val.erGyldigMobil(mobil)) {
	    		deltagerForm.setMobilMelding("Ugyldig Mobil");
	   		}else {
	   			deltagerForm.setMobil(mobil);
	   			gMobil = true;
	   		}
	   		
		   	if(!val.erGyldigPassord(pass)) {
		   		deltagerForm.setPassordMelding("Ugyldig Passord");
	   		}else {
	   			gPass = true;
	   		}
		   	
	   		if(!val.erGyldigPassordRepetert(pass, passRep)) {
	   			deltagerForm.setPassordRepetertMelding("Ikke likt passord");
	   		}else {
	   			gPassRep = true;
	   		}
	
	   		if(!val.erGyldigKjonn(kjonn)) {
	   			deltagerForm.setKjonnMelding("Ugyldig kjonn");		
	    	}else {
	    		deltagerForm.setKjonn(kjonn);
	    		gKjonn = true;
	    		}
	    		
	    	if((gFnavn && gEnavn && gMobil && gPass && gPassRep && gKjonn && !paameldt)) {
		    	response.sendRedirect("bekreftelse");
	    	}else {
		    
		   
		//bruke passordhash greiene
		//opprette Deltager element
		//legge deltager inn i databasen
		//Set Session-greier for deltageren
	    		
	    		request.getSession(false).setAttribute("input", deltagerForm);
	
	    		response.sendRedirect("paamelding");
		
		
		
			
			
		
		
		
	
	}

}
	}
