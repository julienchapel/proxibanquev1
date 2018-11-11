package fr.formation.proxibanquev1.presentation;

import java.util.Scanner;

import fr.formation.proxibanquev1.metier.Advisor;
import fr.formation.proxibanquev1.metier.Client;

/**
 * Classe permettant d'interagir avec l'utilisateur 
 *              Affiche le menu d'entrée ainsi que le menu d'accèes à un client
 *              Comporte aussi la methode qui récupère la saisie de l'utilisateur
 * 
 * @author Julien_Laila
 *
 */

public class Interaction {

	 /**
     * methode permettant d'afficher un message à l'utilisateur.
     * 
     * @param message
     */
	
	
	Scanner sc = new Scanner(System.in);
	
	 /**
     * mathode permettant de récuperer la saisie de l'utilisateur en utilisant la
     * classe Scanner
     * 
     * @return le type de retour est une variable de type String qui represente la
     *         saisie de l'utilisateur qu'on a récuperé avec le Scanner
     */
	
	public void display(String message) {
		System.out.println(message);
	}
	
	public String readData() {
		return sc.nextLine();
	}

    /**
     * Methode sans paramètre permattant d'afficher le menu d'entrée à
     * l'utilisateur.
     */
	
	public void mainMenu() {
		
		this.display("Que souhaitez vous faire ?");
		this.display("");
		this.display("   1.    Acceder à un client"); 
		this.display("   2.    Créer un nouveau client");
		this.display("   3.    Sortir du programme");
	}
	
	 /**
     * Methode sans paramètre parmattant d'afficher à l'utilisateur un menu après
     * avoir choisi d'accéder à un client.
     * 
     */
	
public void clientMenu() {
		this.display("");
		this.display("que souhaitez vous faire  ?");
		this.display("");
		this.display("   1.    Modifier les informations du client"); 
		this.display("   2.    Lire les information du client");
		this.display("   3.    Supprimer le client");
		this.display("   4.    Revenir au Menu précédent");
		
	}
	
}



