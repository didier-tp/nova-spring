package tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tp.MySpringBootApplication;
import tp.entity.Compte;
import tp.service.ServiceCompte;

//test unitaire (JUnit)

//Solutions des Tps sur https://github.com/didier-tp/nova-spring


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations={"/springContext.xml"})
//@ContextConfiguration(classes={SpringConfig.class})
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceCompte {
	
	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	@Test
	public void testRechercherCompteParNumero() {
		Compte c1 = serviceCompte.rechercherCompteParNumero(1L);
		System.out.println(c1.getLabel());
		Assert.assertTrue(c1.getNumero()==1L);
	}
}
