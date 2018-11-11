package fr.formation.proxibanquev1.metier;

/**
 * La classe Account définit le compte boncaire d'un client avec ses différent attributs.
 * C'est la sur classe des deux classes SavingAccount et CurrentAccount;
 * 
 * @author Julien_Laila
 *
 */

public class Account {

	String accountNumber;
	String openingDate;
	float balanceCurrency;
	
	 /**
     * Construit un compte bancaire  spécifié avec son numéro de compte, son date de crèation et son solde.
     * @param accountNumber le numéro du  compte.
     * @param openingDate la date de crèation.
     * @param balanceCurrency le solde.
     */
	
	public Account(String accountNumber, String openingDate, float balanceCurrency) {
	
	this.accountNumber = accountNumber;
	this.openingDate = openingDate;
	this.balanceCurrency = balanceCurrency;
	
	
}
	public Account() {
		
	}
}
