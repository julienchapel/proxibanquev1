package fr.formation.proxibanquev1.metier;

public class Account {

	String accountNumber;
	String openingDate;
	float balanceCurrency;
	
	public Account(String accountNumber, String openingDate, float balanceCurrency) {
	
	this.accountNumber = accountNumber;
	this.openingDate = openingDate;
	this.balanceCurrency = balanceCurrency;
	
	
}
	public Account() {
		
	}
}
