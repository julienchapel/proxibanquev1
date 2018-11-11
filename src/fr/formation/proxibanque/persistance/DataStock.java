package fr.formation.proxibanque.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxibanquev1.metier.Advisor;
import fr.formation.proxibanquev1.metier.Agency;
import fr.formation.proxibanquev1.metier.Client;

/**
 * Classe permetant de stocker les données du programme.
 * 
 * @author 
 *
 */

public class DataStock {
	
	public List<Agency> agencyList;

	/**
	 * Construit un DataStock spécifié  par sa liste d'agence.
	 */
public DataStock() {
		
		this.agencyList = new ArrayList<>();
		
	}
	

}
