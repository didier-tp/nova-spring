package tp.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.entity.Compte;
import tp.service.ServiceCompte;

//test unitaire (JUnit)

public class TestServiceCompte {
	private ServiceCompte serviceCompte; //à tester
	
	@Before
	public void initTest() {
		//...
	}
	
	@Test
	public void testRechercherCompteParNumero() {
		Compte c1 = serviceCompte.rechercherCompteParNumero(1L);
		System.out.println(c1.getLabel());
		Assert.assertTrue(c1.getNumero()==1L);
	}
}
