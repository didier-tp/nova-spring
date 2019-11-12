package tp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.dao.CompteDao;
import tp.entity.Compte;

@Service //hérite de @Component
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired //sur le private ou bien sur le setCompteDao(...)
	//via @Autowired , on demande au framework spring d'initialiser la variable compteDao
	//en référençant un composant spring existant compatible avec l'interface CompteDao.
	private CompteDao compteDao; //pour référencer le dao en arrière plan
	
	public ServiceCompteImpl() {
		System.out.println("dans constructeur,compteDao= " + compteDao);
	}
	
	@PostConstruct
	public void initAfterInjections() {
		System.out.println("dans méthode préfixée par @PostConstruct,compteDao= " + compteDao);
	}
	
	//setter jouant ici le rôle de fonction 
	//d'injection de dépendance
	public void setCompteDao(CompteDao compteDao) {
		this.compteDao = compteDao;
	}

	@Override
	public Compte rechercherCompteParNumero(Long num) {
		return compteDao.findById(num);//au délègue au dao
	}

	@Override
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sauvegarderCompte(Compte c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Compte> recupererComptesDuClient(long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
