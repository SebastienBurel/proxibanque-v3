/**package fr.gtm.projetwebservice.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.gtm.projetwebservice.dao.exceptions.AccountNotFoundDaoException;
import fr.gtm.projetwebservice.dao.ConseillerDao;
import fr.gtm.projetwebservice.dao.ClientDao;
import fr.gtm.projetwebservice.domaine.Conseiller;

public class ConseillerDaoTestCase {

	@Test
	public final void getClientsByConseillerId(long idConseiller) {
		
		try {
			ClientDAO cl = new ClientDAO();
			List<Client> liste = clientDAO.getClientByConseillerId();
			assertNotNull(liste);
			assertEquals(3, liste.size());
			for(Conseiller item : liste)			{
				System.out.println(item);
			}
			
		} catch (DaoException e) {
			fail(e.getMessage());
		}
		
	}
/**
	@Test
	public final void testCreate() {
		
		ConseillerDao conseillerDao = new ConseillerDaoImpl();
		try {
			//Client client = new Client(0,"OUAHIDI","Hafid","06300","17 rue droite","Nice","0619643172");
			Conseiller conseiller = new Conseiller(99,"Martin","Eve","martineve","9876");
			
			conseillerDao.create(conseiller);
		
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		} 
	}
	
	@Test
	public final void testSearchByLogin() {
		try {
			ConseillerDao conseillerDao = new ConseillerDaoImpl();
			Conseiller conseiller = conseillerDao.searchByLogin("martineve");
			assertNotNull(conseiller);
			assertEquals("Martin", conseiller.getNom());
			System.out.println(conseiller);
			
			
		} catch (ElementNotFoundDaoException e) {
			fail(e.getMessage());
			
		} catch (DaoException e) {
			fail(e.getMessage());
		}
		
	}
	@Test
	public void testUpdate() {
		try {
			ConseillerDao conseillerDao = new ConseillerDaoImpl();
			Conseiller conseiller = new Conseiller(2,"Martin","Eve","martineve","0000");
			conseillerDao.update(conseiller);
					
		} catch (ElementNotFoundDaoException e) {
			fail(e.getMessage());
			
		} catch (DaoException e) {
			fail(e.getMessage());	
		}
	}
	
	@Test
	public final void testRemove() {
		try {
			ConseillerDao conseillerDao = new ConseillerDaoImpl();
			conseillerDao.remove(7);
						
		} catch (ElementNotFoundDaoException e) {
			fail(e.getMessage());
			
		} catch (DaoException e) {
			fail(e.getMessage());
		}

	}
	
	@Test(expected=ElementNotFoundDaoException.class)
	public final void testRemoveWithException() throws ElementNotFoundDaoException {
		try {
			ConseillerDao conseillerDao = new ConseillerDaoImpl();
			conseillerDao.remove(1000);
						
		} catch (DaoException e) {
			fail(e.getMessage());
		} 

	}
}
**/