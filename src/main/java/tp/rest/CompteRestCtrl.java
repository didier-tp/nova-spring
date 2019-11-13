package tp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.entity.Compte;
import tp.service.ServiceCompte;


//controleur REST pour les comptes bancaires
@RestController
@RequestMapping(value="/rest/compte" , headers="Accept=application/json")
public class CompteRestCtrl {
	
	@Autowired //injection du service métier pour déléguer traitements
	private ServiceCompte serviceCompte;
	
	//http://localhost:8080/myMvcSpringBootApp/rest/compte?numCli=1
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Compte> getComptesByCriteria(@RequestParam(value="numCli",required=false) 
	                                          Long numClient){
		if(numClient==null) {
			return  null;
			//return serviceCompte.rechercherTousLesComptes(); //à coder et à appeler
		}
		else {	return serviceCompte.recupererComptesDuClient(numClient);
		}	
	}
	//http://localhost:8080/myMvcSpringBootApp/rest/compte/1
	@RequestMapping(value="/{numCompte}" , method=RequestMethod.GET)
    public  Compte getCompteByNum(@PathVariable("numCompte") Long num){
		return serviceCompte.rechercherCompteParNumero(num);
	}

}
