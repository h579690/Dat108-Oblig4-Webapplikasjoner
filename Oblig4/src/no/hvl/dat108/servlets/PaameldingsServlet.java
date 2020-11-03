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
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   
		request.getRequestDispatcher("WEB-INF/jsp/paameldingsskjema.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fnavn = (String) request.getParameter("fornavn");
		String enavn = request.getParameter("etternavn");
		String mobil = request.getParameter("mobil");
		String pass = request.getParameter("passord");
		String passRep = request.getParameter("passordRepetert");
		String kjonn = request.getParameter("kjonn");
		
		boolean paameldt = false; // Skal komme databasekode her
		boolean gFnavn = true ,
				gEnavn = false,
				gMobil = false, 
				gPass = false,
				gPassRep = false, 
				gKjonn = false;
		
		 if(request.getSession(false) == null){
		    	
		    }else {
		
		    	if((!gFnavn || !gEnavn || !gMobil || !gPass || !gPassRep || !gKjonn) && !paameldt) {
		
		    		if(!val.erGyldigNavn(fnavn) ) {
		    			request.getSession().setAttribute("errorFnavn", "Ugyldig fornavn");
		    			gFnavn = true;
		    		}
		    		if(!val.erGyldigNavn(enavn)) {
		    			request.getSession().setAttribute("errorEnavn","Ugyldig enavn" );
		    			gEnavn = true;
		    		}
		    		if(!val.erGyldigMobil(mobil)) {
		    			request.getSession().setAttribute("errorMobil", "Ugyldig mobil");
		    			gMobil = true;
		    		}
		    		if(!val.erGyldigPassord(pass)) {
		    			request.getSession().setAttribute("errorPass", "Ugyldig passord");
		    			gPass = true;
		    		}
		    		if(!val.erGyldigPassordRepetert(pass, passRep)) {
		    			request.getSession().setAttribute("errorPassRep", "Ikke likt passord");
		    			gPassRep = true;
		    		}
		
		    		if(!val.erGyldigKjonn(kjonn)) {
		    			request.getSession().setAttribute("errorKjonn", "Ugyldig kjonn");
		    			gKjonn = true;
		    		}
		    		response.sendRedirect("paamelding");
		
		    	}
		    }
		//bruke passordhash greiene
		//opprette Deltager element
		//legge deltager inn i databasen
		//Set Session-greier for deltageren
	
		response.sendRedirect("bekreftelse");
		
		
		
			
			
		
		
		
	
	}

}
