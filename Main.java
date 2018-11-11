package fr.formation.proxibanquev1;

import fr.formation.proxibanquev1.metier.Management;

/**
* Classe principale contenant la méthode main.
* @author Julien_Laila
*
*/

public class Main {
	
	/**
	 * Point d'entrée du programme.
	 * La méthode main appelle la méthode start() de la classe Management pour lancer le programme.
	 * 
	 * @param args aucun argument utilisé.
	 */

	public static void main(String[] args) {

		Management m = new Management();
		
		m.start();
		
	}

	
}
