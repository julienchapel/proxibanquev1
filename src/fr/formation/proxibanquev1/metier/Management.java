package fr.formation.proxibanquev1.metier;

import java.util.ArrayList;
import java.util.Scanner;

import fr.formation.proxibanque.persistance.DataStock;
import fr.formation.proxibanquev1.presentation.Interaction;

public class Management {

	DataStock dataStock = new DataStock();
	Interaction interaction = new Interaction();
	int clientNumber = 0;
	public boolean running = true;

	public void start() { 

		loadtestData();
		while (this.running) {
			this.ManageMainMenu();
		}
		
		readClient();

	}

	public void createClient() {

		this.interaction.display("Vous avez choisi de créer un nouveau client");
		this.interaction.display("Veuillez indiquer le nom du client ");
		String InputName = this.interaction.readData();
		this.interaction.display("Veuillez indiquer le prénom du client ");
		String InputFirstname = this.interaction.readData();
		this.interaction.display("Veuillez indiquer l'adresse du client ");
		String InputAdress = this.interaction.readData();
		this.interaction.display("Veuillez indiquer le code postal du client ");
		String InputZipCode = this.interaction.readData();
		this.interaction.display("Veuillez indiquer la ville du client ");
		String InputCity = this.interaction.readData();
		this.interaction.display("Veuillez indiquer le numéro de téléphone du client ");
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

		this.interaction.display("");
		this.interaction.display("");
		this.dataStock.agencyList.get(0).advisorList.get(0).listClient.add(newClient);
	}

	public void removeClient() {

			this.dataStock.agencyList.get(0).advisorList.get(0).listClient.remove(clientNumber); 

		}

	public void editClient() {
		
		String userInput = this.interaction.readData();
		if (userInput.matches("^-?[0-9]*$") && Integer.parseInt(userInput)<dataStock.agencyList.get(0).advisorList.get(0).listClient.size()) {
		int p = Integer.parseInt(userInput);
		
		if(p==1) {
			modifyClientInformations(clientNumber);		
		
		}
		
		if(p==2) {
			readInformation(clientNumber);
		}
		
		if(p==3) {
			this.interaction.display(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name
							+ " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname
							+ " " + "a été supprimé(e)"); 
			this.interaction.display("");
			this.interaction.display("");
		this.removeClient();
		}
		}else {
			this.interaction.display("Veuillez rentre un chiffre parmi la liste proposée");
			this.interaction.display("");
			this.interaction.display("que souhaitez vous faire  ?");
			this.interaction.display("1) Modifier les informations du client"); 
			this.interaction.display("2) Lire les information du client");
			this.interaction.display("3) Supprimer le client");
			
			this.editClient();
		}
	}
		
	public void readInformation(int clientNumber) {
		this.interaction.display(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname + "\n"
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse + "\n"
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode + " "
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city + "\n"
				+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone);
		
		this.interaction.display("");
		this.interaction.display("");
	}
	
	public void modifyClientInformations(int clientNumber) {
	
		this.interaction.display("Quel paramètre souhaitez vous modifier ?");
		this.interaction.display("");
		this.interaction.display(0 + " Le nom");
		this.interaction.display(1 + " Le prénom");
		this.interaction.display(2 + " L'adresse");
		this.interaction.display(3 + " Le code postal");
		this.interaction.display(4 + " La ville");
		this.interaction.display(5 + " Le numéro de téléphone");
		
		String InputNameClient = this.interaction.readData();
		
		int n = Integer.parseInt(InputNameClient);
		
		
		if (n==0) {this.interaction.display("veuillez rentrer le nouveau nom ");
		
		String InputNewName = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name = InputNewName;
		}
		if (n==1) {this.interaction.display("veuillez rentrer le nouveau prénom ");
		String InputNewFirstName = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname = InputNewFirstName;
		
		}
		if (n==2) {this.interaction.display("veuillez rentrer la nouvelle adresse ");
		String InputNewAdress = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse = InputNewAdress;
		
		}
		if (n==3) {this.interaction.display("veuillez rentrer le nouveau code postal ");
		String InputNewZipCode = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode = InputNewZipCode;
		
		}
		if (n==4) {this.interaction.display("veuillez rentrer la nouvelle ville ");
		String InputNewCity = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city = InputNewCity;
		
		}
		if (n==5) {this.interaction.display("veuillez rentrer le nouveau numéro de téléphone ");
		String InputNewPhone = this.interaction.readData();
		dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone = InputNewPhone;
		
		this.interaction.display("");
		this.interaction.display("");
		}
		
	}
	
	public void readClient() {

		String userInput = this.interaction.readData();
		if (userInput.equals("1")) {
			this.interaction.display("Vous avez choisi d'accéder à un fichier client");
			this.interaction.display("Voici la liste des clients");
			this.interaction.display("");

			readDataClient();

			this.interaction.display(" ");
			this.interaction.display("Quel client souhaitez vous sélectionner ?");
			this.interaction.display("Nom ?");
			String InputNameClient = this.interaction.readData();
			this.interaction.display("Prénom ?");
			String InputFirstNameClient = this.interaction.readData();
			this.interaction.display("Vous avez choisi " + InputNameClient + " " + InputFirstNameClient);

			this.interaction.clientMenu();

		}
		if (userInput.equals("2")) {

			createClient();

		}
		if (userInput.equals("3")) {
			this.interaction.display("Merci de votre visite");
			System.exit(0);
		}

	}

	public void transfert(int somme) {

	}

	public void loadtestData() {

		this.dataStock.agencyList = new ArrayList<>();
		Agency agency = new Agency("abc12", "12/01/1998");
		Manager manager = new Manager("bernard");

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

			this.interaction.display(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name + " "
					+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);

		}
		this.interaction.display("");

	}

	public void chooseClient() {
		if(dataStock.agencyList.get(0).advisorList.get(0).listClient.size()==0) {
			this.interaction.display("cette liste ne contient pas de client");
			this.interaction.display("veuillez créer un nouveau client");
			createClient();
		}else {
			
		
		this.interaction.display("Quel client souhaitez vous sélectionner ?");
		for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {
			this.interaction.display(i +" "+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name 
									+ " " +dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);
		}
		this.interaction.display("");
		this.interaction.display("Choisissez le chiffre du client en question");
		String InputNameClient = this.interaction.readData();
		if (InputNameClient.matches("^-?[0-9]*$") && Integer.parseInt(InputNameClient)<dataStock.agencyList.get(0).advisorList.get(0).listClient.size()) {
		int j = Integer.parseInt(InputNameClient);
		this.interaction.display("Vous avez choisi " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j).name
												+ " " +dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j).firstname);
		this.clientNumber = j;	
		
		
		this.interaction.display("");
		this.interaction.display("que souhaitez vous faire  ?");
		this.interaction.display("1) Modifier les informations du client"); 
		this.interaction.display("2) Lire les information du client");
		this.interaction.display("3) Supprimer le client");
		
		this.editClient();
		
		}else {
			
			this.interaction.display("Veuillez rentre un chiffre parmi la liste proposée");
			chooseClient();
			
			}
		}
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
