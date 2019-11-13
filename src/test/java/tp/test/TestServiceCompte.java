package tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import tp.MySpringBootApplication;
import tp.entity.Client;
import tp.entity.Compte;
import tp.service.ServiceCompte;

//test unitaire (JUnit)

//Solutions des Tps sur https://github.com/didier-tp/nova-spring


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations={"/springContext.xml"})
//@ContextConfiguration(classes={SpringConfig.class})
@SpringBootTest(classes= {MySpringBootApplication.class})
//@ActiveProfiles("postgresql")
//@ActiveProfiles("mysql")
@ActiveProfiles("h2")
public class TestServiceCompte {
	
	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	@Test
	public void testRechercherComptesDuClient() {
		//créer un client
		Client cliA = new Client(null,"Bon", "Jean");
		serviceCompte.sauvegarderClient(cliA);
		
		//créer 3 comptes dont 2 rattachés au client
		Compte cA = new Compte(null,"compteA",50.0);
		cA.setClient(cliA); serviceCompte.sauvegarderCompte(cA);
		Compte cB = new Compte(null,"compteB",150.0);
		cB.setClient(cliA); serviceCompte.sauvegarderCompte(cB);
		Compte cC = new Compte(null,"compteC",250.0);
		serviceCompte.sauvegarderCompte(cC);
		
		//rechercher les comptes rattachés au client , normalement 2
		List<Compte> comptes = serviceCompte.recupererComptesDuClient(cliA.getNumero());
		Assert.assertTrue(comptes.size()==2);
		for(Compte c : comptes) {
			System.out.println(c);
		}
	}
	
	
	@Test
	public void testRechercherCompteParNumero() {
		
		Compte nouveauCompte = new Compte(null,"compte Abc",50.0);
		serviceCompte.sauvegarderCompte(nouveauCompte);
		Long idCompte = nouveauCompte.getNumero();//recuperer valeur auto incrementée
		
		Compte cptRelu = serviceCompte.rechercherCompteParNumero(idCompte);
		System.out.println(cptRelu.getLabel());
		Assert.assertTrue(cptRelu.getNumero()==idCompte);
		//...
	}
}
