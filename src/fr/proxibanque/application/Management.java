package fr.proxibanque.application;

import java.util.ArrayList;
import java.util.Scanner;

import fr.proxi.client.Client;
import fr.proxibanque.data.DataStock;
import fr.proxibanque.metier.Advisor;
import fr.proxibanque.metier.Agency;

public class Management {

	DataStock dataStock = new DataStock();
	Interaction interaction = new Interaction();
	int clientNumber = 0;
	public boolean running = true;

	public void start() { // permet de lancer le programme via la methode display

		loadtestData();
		while (this.running) {
			this.ManageMainMenu();
		}
		
		// this.interaction.mainMenu();
		readClient();

	}

	public void createClient() {

		System.out.println("Vous avez choisi de créer un nouveau client");
		System.out.println("Veuillez indiquer le nom du client ");
		String InputName = this.interaction.readData();
		System.out.println("Veuillez indiquer le prénom du client ");
		String InputFirstname = this.interaction.readData();
		System.out.println("Veuillez indiquer l'adresse du client ");
		String InputAdress = this.interaction.readData();
		System.out.println("Veuillez indiquer le code postal du client ");
		String InputZipCode = this.interaction.readData();
		System.out.println("Veuillez indiquer la ville du client ");
		String InputCity = this.interaction.readData();
		System.out.println("Veuillez indiquer le numéro de téléphone du client ");
		String InputPhoneNumber = this.interaction.readData();

		Client newClient = new Client(InputName, InputFirstname, InputAdress, InputZipCode, InputCity,
				InputPhoneNumber);

		System.out.println("Le client suivant a bien été créée");
		System.out.println(InputName);
		System.out.println(InputFirstname);
		System.out.println(InputAdress);
		System.out.println(InputZipCode);
		System.out.println(InputCity);
		System.out.println(InputPhoneNumber);

		this.dataStock.agencyList.get(0).advisorList.get(0).listClient.add(newClient);
	}

	public void removeClient() {

			this.dataStock.agencyList.get(0).advisorList.get(0).listClient.remove(clientNumber); 

		}

	public void editClient() {
		
		String userInput = this.interaction.readData();
		int p = Integer.parseInt(userInput);
		
		if(p==1) {
			modifyClientInformations(clientNumber);		
		
		}
		
		if(p==2) {
			readInformation(clientNumber);
		}
		
		if(p==3) {
		System.out.println(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name
							+ " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname
							+ " " + "a été supprimé(e)"); 
		this.removeClient();
		
		
		}
		}
		
	public void readInformation(int clientNumber) {
		System.out.println(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone);
		
	}
	
	public void modifyClientInformations(int clientNumber) {
	
		System.out.println("Quel paramètre souhaitez vous modifier ?");
		System.out.println("");
		System.out.println(0 + " Le nom");
		System.out.println(1 + " Le prénom");
		System.out.println(2 + " L'adresse");
		System.out.println(3 + " Le code postal");
		System.out.println(4 + " La ville");
		System.out.println(5 + " Le numéro de téléphone");
		
		String InputNameClient = this.interaction.readData();
		int n = Integer.parseInt(InputNameClient);
		
		
		if (n==0) {System.out.println("veuillez rentrer le nouveau nom ");
		
		String InputNewName = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name = InputNewName;
		}
		if (n==1) {System.out.println("veuillez rentrer le nouveau prénom ");
		String InputNewFirstName = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname = InputNewFirstName;
		
		}
		if (n==2) {System.out.println("veuillez rentrer la nouvelle adresse ");
		String InputNewAdress = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse = InputNewAdress;
		
		}
		if (n==3) {System.out.println("veuillez rentrer le nouveau code postal ");
		String InputNewZipCode = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode = InputNewZipCode;
		
		}
		if (n==4) {System.out.println("veuillez rentrer la nouvelle ville ");
		String InputNewCity = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city = InputNewCity;
		
		}
		if (n==5) {System.out.println("veuillez rentrer le nouveau numéro de téléphone ");
		String InputNewPhone = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone = InputNewPhone;
		
		}
		
	}
	
	public void readClient() {

		String userInput = this.interaction.readData();
		if (userInput.equals("1")) {
			System.out.println("Vous avez choisi d'accéder à un fichier client");
			System.out.println("Voici la liste des clients");
			System.out.println("");

			readDataClient();

			System.out.println(" ");
			System.out.println("Quel client souhaitez vous sélectionner ?");
			System.out.println("Nom ?");
			String InputNameClient = this.interaction.readData();
			System.out.println("Prénom ?");
			String InputFirstNameClient = this.interaction.readData();
			System.out.println("Vous avez choisi " + InputNameClient + " " + InputFirstNameClient);

			this.interaction.clientMenu();

		}
		if (userInput.equals("2")) {

			createClient();

		}
		if (userInput.equals("3")) {
			System.out.println("Merci de votre visite");
			System.exit(0);
		}

	}

	public void transfert(int somme) {

	}

	public void loadtestData() {

		this.dataStock.agencyList = new ArrayList<>();
		Agency agency = new Agency("abc12", "12/01/1998");

		agency.advisorList = new ArrayList<>();
		Advisor advisor = new Advisor("conseiller 1");

		advisor.listClient.add(new Client("Lebon", "Michel", "3 rue des gresillons", "75100", "paris", "0123158487"));
		advisor.listClient
				.add(new Client("Lemarchand", "Nicole", "12 rue Jules Ferry", "91200", "melun", "0684582317"));
		advisor.listClient
				.add(new Client("Ardoin", "Patrick", "6 avenue du Marché", "52500", "Strasborg", "0267988489"));
		advisor.listClient.add(new Client("Ledee", "Sylvie", "1 rue des papillons", "33200", "Bordeaux", "0325879845"));

		agency.advisorList.add(advisor);
		dataStock.agencyList.add(agency);

	}

	public void readDataClient() {

		for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {

			System.out.println(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name + " "
					+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);

		}
		System.out.println("");

	}

	public void chooseClient() {
		System.out.println("Quel client souhaitez vous sélectionner ?");
		for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {
			System.out.println(i +" "+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name 
									+ " " +dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);
		}
		System.out.println("");
		System.out.println("Choisissez le chiffre du client en question");
		String InputNameClient = this.interaction.readData();
		int j = Integer.parseInt(InputNameClient);
		System.out.println("Vous avez choisi " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j).name
												+ " " +dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j).firstname);
		this.clientNumber = j;	
		
		this.interaction.display("");
		this.interaction.display("que souhaitez vous faire  ?");
		this.interaction.display("1) Modifier les informations du client"); 
		this.interaction.display("2) Lire les information du client");
		this.interaction.display("3) Supprimer le client");
		
		this.editClient();
		//this.interaction.clientMenu();
		
		//System.out.println("Nom ?");
		//String InputNameClient = this.interaction.readData();
		//System.out.println("prénom ?");
		//String InputFirstNameClient = this.interaction.readData();

		//for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {

			//if (InputNameClient.equals(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name)
				//&& InputFirstNameClient.equals(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname)){

				//System.out.println("Vous avez choisi " + InputNameClient + " " + InputFirstNameClient);

				//System.out.println("");
			//} 
		//}
		
		
		
		
	
	}

	public void exitProxibanque() {
		this.running = false;
		System.exit(0);
	}

	public void ManageMainMenu() {
		this.interaction.mainMenu();
		String userchoise = this.interaction.readData();

		if (userchoise.equals("1")) {
			this.readDataClient();
			this.chooseClient();
		}

		if (userchoise.equals("2")) {

			this.createClient();
		}

		if (userchoise.equals("3")) {
			this.exitProxibanque();
		}
	}

}
