package fr.proxibanque.metier;

import java.util.ArrayList;
import java.util.List;

import fr.proxi.client.Client;

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
