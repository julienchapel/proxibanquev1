package fr.formation.proxibanquev1.metier;

/**

 * La classe CurrentAccount  définit le compte courant d'un client, elle hérite ses attributs de sa sur  classe Account.

 * 

 * @author  Julien_laila

 *

 */

 public class CurrentAccount extends Account{

	 

 	/**

	 *  Construit un compte courant spécifié par son avec son numéro de compte, son date de crèation et son solde.

	 * @param accountNumber

	 * @param openingDate

	 * @param balanceCurrency

	 */

	

	

	public CurrentAccount(String accountNumber, String openingDate, float balanceCurrency ) {

		 super(accountNumber , openingDate , balanceCurrency);

		 

	}

	

	public CurrentAccount() {

		super();

	}

}
