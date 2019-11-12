package tp.service;

import java.util.List;

import tp.dao.CompteDao;
import tp.entity.Compte;

public class ServiceCompteImpl implements ServiceCompte {
	
	//@Autowired
	private CompteDao compteDao; //pour référencer le dao en arrière plan
	
	
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
