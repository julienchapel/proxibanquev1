package fr.proxibanque.application;

import java.util.Scanner;

import fr.proxi.client.Client;
import fr.proxibanque.metier.Advisor;

public class Interaction {

	Scanner sc = new Scanner(System.in);
	
	public void display(String message) {
		System.out.println(message);
	}
	
	public String readData() {
		return sc.nextLine();
	}
	
	
	public void mainMenu() {
		
		this.display("quel est votre choix  ?");
		this.display("1) Acceder à un client"); 
		this.display("2) Créer un nouveau client");
		this.display("3) Sortir du programme");
		
	}
	
	
public void clientMenu() {
		this.display("");
		this.display("que souhaitez vous faire  ?");
		this.display("1) Modifier les informations du client"); 
		this.display("2) Lire les information du client");
		this.display("3) Supprimer le client");
		
		
	}
	
}



