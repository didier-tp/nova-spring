package tp.service;

import java.util.List;

import tp.entity.Compte;

public interface ServiceCompte {
	public Compte rechercherCompteParNumero(Long num);
	public void transferer(double montant, long numCptDeb,long numCptCred);
	public void sauvegarderCompte(Compte c);//création ou mise à jour
	public List<Compte> recupererComptesDuClient(long numClient);
}
