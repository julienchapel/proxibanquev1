package fr.proxibanque.metier;

import java.util.ArrayList;
import java.util.List;

import fr.proxi.client.Client;

public class Agency {

	public String idNumber;
	public String creationDate;
	public List<Advisor> advisorList;
	
	public Agency(String idNumber, String creationDate) {
		
		this.idNumber = idNumber;
		this.creationDate = creationDate;
		this.advisorList = new ArrayList<>();
		
		
	}
	
	
}
