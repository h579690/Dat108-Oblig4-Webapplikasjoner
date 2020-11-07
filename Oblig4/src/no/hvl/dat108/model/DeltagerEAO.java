package no.hvl.dat108.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DeltagerEAO {

	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public synchronized void leggTilDeltager(String mobil, String fornavn, String etternavn, String passordSalt, String passordHash, char kjonn) {
		Deltager deltager = new Deltager(mobil, fornavn, etternavn, passordSalt, passordHash, kjonn);
		em.persist(deltager);
	}
	
	public synchronized void leggTilDeltager2(Deltager nyDeltager) {
		em.persist(nyDeltager);
	}
	
	
	public synchronized Deltager finnEnDeltager(String mobil) {
		return em.find(Deltager.class, mobil);
	}
	

	//Tungvint måte
	public synchronized List<Deltager> deltagerListe() {
		List<Deltager> d = null;
		TypedQuery<Deltager> query = em.createQuery("SELECT d FROM Deltager d" , Deltager.class);
		d = query.getResultList();
		return d;
		
	}
}
