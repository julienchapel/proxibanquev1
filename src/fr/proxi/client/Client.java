package fr.proxi.client;

public class Client {
	
	
	public String name;
	public String firstname;
	public String adresse;
	public String zipCode;
	public String city;
	public String phone;

	public Client(String name, String firstname, String  adresse,
			String zipCode, String city, String phone) {
		
		this.name = name;
		this.firstname = firstname;
		this.adresse = adresse;
		this.zipCode = zipCode;
		this.city = city;
		this.phone = phone;
		
		
	}
 
	public Client (String name, String firstname) {
		
		this.name = name;
		this.firstname = firstname;
	}
	
}
