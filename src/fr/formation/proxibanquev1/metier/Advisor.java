package fr.formation.proxibanquev1.metier;

import java.util.ArrayList;
import java.util.List;

public class Advisor {

	public String id;
	public List<Client> listClient;
	
	public Advisor(String id) {
		 
		this.id = id;
		
		
		this.listClient = new ArrayList<>();
		
	}
	
	public Advisor() {
		
	}
	
}
