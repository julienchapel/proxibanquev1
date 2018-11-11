package fr.formation.proxibanquev1.metier;

/**

 * La classe SavingAccount  définit le compte d'épargne d'un client, elle hérite ses attributs de sa sur  classe Account.

 * 

 * @author  Julien_laila

 *

 */



 public class SavingAccount extends Account{

    

	 /**

		 *  Construit un compte d'épargne spécifié par son avec son numéro de compte, son date de crèation et son solde.

		 * @param accountNumber

		 * @param openingDate

		 * @param balanceCurrency

		 */

	 public SavingAccount(String accountNumber, String openingDate, float balanceCurrency) {

		 super(accountNumber , openingDate , balanceCurrency);

	}

	 public SavingAccount() {

		 super();

		 

	 }

		 

	 

	

	

}