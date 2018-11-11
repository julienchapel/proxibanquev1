package fr.formation.proxibanquev1.metier;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe sert à définir un conseiller (advisor) via son identifiant (id) et la  sa liste des client.
 * @author Julien_Laila
 *
 */

public class Advisor {

	public String id;
	public List<Client> listClient;
	
	/**
     *  Ceci construit un conseiller(advisor) spécifié par son identifiant.
     * @param id l'identifiant du conseiller
     */
	
	public Advisor(String id) {
		 
		this.id = id;
		
		
		this.listClient = new ArrayList<>();
		
	}
	
	/**
     * Construit un conseiller (advosor)  sans paramètre.
     */
	
	public Advisor() {
		
	}
	
}
