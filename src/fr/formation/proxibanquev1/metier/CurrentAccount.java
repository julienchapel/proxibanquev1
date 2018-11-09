package fr.formation.proxibanquev1.metier;

public class CurrentAccount extends Account{

	public float decouvert;
	public CurrentAccount(String accountNumber, String openingDate, float balanceCurrency , float decouvert) {
		 super(accountNumber , openingDate , balanceCurrency);
		 this.decouvert = decouvert;
	}
	
	public CurrentAccount() {
		super();
	}
}
