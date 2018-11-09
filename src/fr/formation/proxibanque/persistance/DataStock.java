package fr.formation.proxibanque.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxibanquev1.metier.Advisor;
import fr.formation.proxibanquev1.metier.Agency;
import fr.formation.proxibanquev1.metier.Client;

public class DataStock {
	
	public List<Agency> agencyList;
	 
public DataStock() {
		
		this.agencyList = new ArrayList<>();
		
	}
	

}
