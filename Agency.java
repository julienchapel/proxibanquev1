package fr.formation.proxibanquev1.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Cette classe définit une agence (agency) avec un identifiant(idNumber), une date de 
 * création (creationDate), une liste de conseillers(advisors) et un gérant (manager). 
 * @author Julien_Laila
 *
 */

public class Agency {

	public String idNumber;
	public String creationDate;
	public List<Advisor> advisorList;
	
	/**
	 * Construit une agence(agency) spésifiée  par son identifiant  (idNumber) et  sa date de crèation (creationDate).
	 * @param idNumber est  le numéro identifiant de l'agence.
	 * @param creationDate est la date de crèation de l'agence.
	 */
	
	public Agency(String idNumber, String creationDate) {
		
		this.idNumber = idNumber;
		this.creationDate = creationDate;
		this.advisorList = new ArrayList<>();
		
		
	}
	
	
}
