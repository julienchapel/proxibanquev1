package fr.formation.proxibanquev1.metier;

import java.util.ArrayList;
import java.util.Scanner;

import fr.formation.proxibanque.persistance.DataStock;
import fr.formation.proxibanquev1.presentation.Interaction;

/**
* La classManagement réunie toutes les méthodes permettant le fonctionnement du programme
* 
* Sont importés les packages permetant l'interaction avec l'utilisateur et le stockage des données clients
* @author Julien_Laila
*
*/

public class Management {

	/**
	* On crée un nouveau dataStock de la classe DataStock pour le stockage des données
	* et un nouvel objet interaction de la class Interaction pour l'affichage écran utilisateur
	* 
	* @Param clientNumber
	*                      représente l'index du client dans la liste permetant une utilisation plus simple par plusieurs methodes
	* @Param running                     
	*                 sera utilisé pour permetre à l'utilisateur de relancer le programme autant de fois qu'il veur et de le quitter
	* @Param nom et prenom                
	*                     sont des variables de types string en mots vides qui seront indéxées une fois le client choisi
	*/
	
	public DataStock dataStock = new DataStock();
	public Interaction interaction = new Interaction();
	public int clientNumber = 0;
	public boolean running = true;
	public String nom ="";
	public String prenom ="";
	
	
	/**
	*La methode start() appelée dans la methode main lance le programme
	*Tout d'abord on utilise la méthode loadtestData() qui vapermettre au programme de récupérer toutes les données
	*enregistrées dans le dataStock
	*
	*On lance une boucle while qui tant que le boolean running sera à true utilisera la methode ManageMainMenu()
	*/
	
	public void start() {

		
		loadTestData();
		while (this.running) {
			this.manageMainMenu();
		}

	}

	/**
	 * La methode creatClient() permet à l'utilisateur de créer un nouvau client 
	 * avec son nom , prénom, adresse, code postal, ville et numéro de téléphone
	 * L'utilisateur saisi une chaine de caractére
	 * losque la touche entrée est selectionnée et que rien n'est écrit
	 * le paramètre est tout de meme crée
	 * ex : si pas de nom renseigné le nouveau client aura pour nom NoName
	 * Les paramètres sont ensuite enregistrés dans un nouveau Client appellé newClient qui sera stocké dans la dataStock
	 * Le programme récapitule ensuite les données rentrée par l'utilisateur pour ce nouveau client 
	 * Et affiche la nouvelle liste de client avec la methode readDataClient() 
	 */
	
	public void createClient() {

		this.interaction.display("Veuillez indiquer le nom du client ");

		String InputName = this.interaction.readData();
		if (InputName.equals("")) {
			InputName = "NoName";
		}
		this.interaction.display("Veuillez indiquer le prénom du client ");
		String InputFirstname = this.interaction.readData();
		if (InputFirstname.equals("")) {
			InputFirstname = "NoFirstname";
		}
		this.interaction.display("Veuillez indiquer l'adresse du client ");
		String InputAdress = this.interaction.readData();
		if (InputAdress.equals("")) {
			InputAdress = "No Adress";
		}
		this.interaction.display("Veuillez indiquer le code postal du client ");
		String InputZipCode = this.interaction.readData();
		if (InputZipCode.equals("")) {
			InputZipCode = "No ZipCode";
		}
		this.interaction.display("Veuillez indiquer la ville du client ");
		String InputCity = this.interaction.readData();
		if (InputCity.equals("")) {
			InputCity = "No City";
		}
		this.interaction.display("Veuillez indiquer le numéro de téléphone du client ");
		String InputPhoneNumber = this.interaction.readData();
		if (InputPhoneNumber.equals("")) {
			InputPhoneNumber = "NoPhoneNumber";
		}

		Client newClient = new Client(InputName, InputFirstname, InputAdress, InputZipCode, InputCity,
				InputPhoneNumber);
		this.interaction.display("");
		this.interaction.display("Le client suivant a bien été créée");
		this.interaction.display("");
		this.interaction.display("       " + InputName + "  " + InputFirstname);
		this.interaction.display("       " + InputAdress);
		this.interaction.display("       " + InputZipCode + " " + InputCity);
		this.interaction.display("       " + InputPhoneNumber);

		this.interaction.display("");
		this.dataStock.agencyList.get(0).advisorList.get(0).listClient.add(newClient);
		this.readDataClient();
	}

	/**
	 * Cette methode  removeClient() permet de supprimer un client de la liste de conseiller grace à l'indice clientNumber
	 * @Param clientNumber
	 */
	
	public void removeClient(int clientNumber) {

		this.dataStock.agencyList.get(0).advisorList.get(0).listClient.remove(clientNumber);
		this.readDataClient();

	}

	/** 
	 * La méthode editClient() est utilisée lorsque l'utilisateur a choisi dans le menu pricipal de "choisir un client"
	 * Il lui est proposé de soit modifier les informations du client avec la methode modifyClientInformations()
	 * Soit consulter la totalité des informations du client qui sont tockées dan ladatStock avec la methode readInformations()
	 * Soit supprimer le client avec la methode remove()
	 * Soit revenir au menu précédent c'est à dire à la liste de client via la méthode editClient()
	 * 
	 * La méthode est définie de manière à ce que l'utilisateur ne puisse pas faire autre chose que ce qui lui est proposée 
	 * Dans le cas où son choix n'est pas proposée le programme continuera de renouveler la même demande à l'utilisateur.
	 * 
	 */
	
	public void editClient() {

		String userInput = this.interaction.readData();
		if (userInput.equals("")) {
			this.interaction.display("que souhaitez vous faire  ?");
			this.interaction.display("");
			this.interaction.display("   1.    Modifier les informations de " + nom + " " + prenom);
			this.interaction.display("   2.    Lire les information de " + nom + " " + prenom);
			this.interaction.display("   3.    Supprimer " + nom + " " + prenom);
			this.interaction.display("   4.    Revenir au Menu précédent");

			this.editClient();
		}

		else if (userInput.matches("^?[0-9]*$") && Integer.parseInt(userInput) <= 4) {
			int p = Integer.parseInt(userInput);

			if (p == 1) {
				this.modifyClientInformations(clientNumber);

			}

			if (p == 2) {
				this.readInformation(clientNumber);
			}

			if (p == 3) {
				this.interaction
						.display(dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name + " "
								+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname
								+ " " + "a été supprimé(e)");
				this.interaction.display("");
				this.interaction.display("");
				this.removeClient(clientNumber);
			}
			if (p == 4) {

				this.chooseClient();
			}
		} else {
			this.interaction.display("Veuillez rentre un chiffre parmi la liste proposée");
			this.interaction.display("");
			this.interaction.display("que souhaitez vous faire  ?");
			this.interaction.display("");
			this.interaction.display("   1.    Modifier les informations du client");
			this.interaction.display("   2.    Lire les information du client");
			this.interaction.display("   3.    Supprimer le client");
			this.interaction.display("   4.    Revenir au Menu précédent");

			this.editClient();
		}
	}

	/**
	 * La methode readInformation permet d'afficher les détails en totalité sur chaque client
	 * Il est proposé ensuite à l'utilisateur un menu d'option pour lui eviter de retourner au menu principal
	 * @param clientNumber
	 */
	
	public void readInformation(int clientNumber) {
		this.interaction.display(
				"                " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name
						+ " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).firstname
						+ "\n" + "                "
						+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse + "\n"
						+ "                "
						+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode + " "
						+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city + "\n"
						+ "                "
						+ dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone);

		this.interaction.display("");
		this.interaction.display("");
		this.interaction.display("que souhaitez vous faire  ?");
		this.interaction.display("");
		this.interaction.display("   1.    Modifier les informations de " + nom + " " + prenom);
		this.interaction.display("   2.    Lire les informations de " + nom + " " + prenom);
		this.interaction.display("   3.    Supprimer " + nom + " " + prenom);
		this.interaction.display("   4.    Revenir au Menu précédent");
		this.editClient();

	}

	/**
	 * La methode modifyClientInformation() permet à l'utilisateur de modifier les paramètres d'un client un par un
	 * les options lui sont proposées dans un menu 
	 * Si l'utilisateur rentre autre chose que ce qui est proposé 
	 * Le programme reproposera le menu tant que l'utilisateur n'aura pas fait un choix proposé
	 * La methode est construite de manière à ce que l'utilisateur puisse modifier autant de paramètres qu'il souhaite 
	 * sans avoir à revenir au menu principal à chaque fois
	 * Ilest aussi proposé de revenir au menu précédent au cas où m'utilisateur n'aurait pas choisi le bon client
	 * A chaque modification effectuée un récapitulatif du client est affiché. 
	 * @param clientNumber
	 */
	
	public void modifyClientInformations(int clientNumber) {

		this.interaction.display("Quel paramètre souhaitez vous modifier ?");
		this.interaction.display("");
		this.interaction.display(1 + " Le nom");
		this.interaction.display(2 + " Le prénom");
		this.interaction.display(3 + " L'adresse");
		this.interaction.display(4 + " Le code postal");
		this.interaction.display(5 + " La ville");
		this.interaction.display(6 + " Le numéro de téléphone");
		this.interaction.display(7 + " Aucun Revenir au Menu précédent");

		String InputNameClient = this.interaction.readData();

		if (InputNameClient.equals("")) {
			this.modifyClientInformations(clientNumber);
		} else if (InputNameClient.matches("^?[1-9]*$") && Integer.parseInt(InputNameClient) <= 7) {

			int n = Integer.parseInt(InputNameClient);

			if (n == 1) {
				this.interaction.display("veuillez rentrer le nouveau nom ");

				String InputNewName = this.interaction.readData();
				if (InputNewName.equals("")) {

					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name = "NoName";
					nom = "NoName";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);

				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).name = InputNewName;
					nom = InputNewName;
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				}
			}
			if (n == 2) {
				this.interaction.display("veuillez rentrer le nouveau prénom ");
				String InputNewFirstName = this.interaction.readData();
				if (InputNewFirstName.equals("")) {
					dataStock.agencyList.get(0).advisorList.get(0).listClient
							.get(clientNumber).firstname = "NoFirstname";
					prenom = "NoFirstame";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);

				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient
							.get(clientNumber).firstname = InputNewFirstName;
					this.interaction.display("Voici les nouvelles informations du client");
					prenom = InputNewFirstName;
					this.interaction.display(" ");
					readInformation(clientNumber);

				}
			}
			if (n == 3) {
				this.interaction.display("veuillez rentrer la nouvelle adresse ");
				String InputNewAdress = this.interaction.readData();
				if (InputNewAdress.equals("")) {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).adresse = "NoAdress";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);

				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient
							.get(clientNumber).adresse = InputNewAdress;
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				}
			}
			if (n == 4) {
				this.interaction.display("veuillez rentrer le nouveau code postal ");
				String InputNewZipCode = this.interaction.readData();
				if (InputNewZipCode.equals("")) {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).zipCode = "NoZipCode";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient
							.get(clientNumber).zipCode = InputNewZipCode;
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				}
			}
			if (n == 5) {
				this.interaction.display("veuillez rentrer la nouvelle ville ");
				String InputNewCity = this.interaction.readData();
				if (InputNewCity.equals("")) {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city = "NoCity";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).city = InputNewCity;
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				}
			}
			if (n == 6) {
				this.interaction.display("veuillez rentrer le nouveau numéro de téléphone ");
				String InputNewPhone = this.interaction.readData();
				if (InputNewPhone.equals("")) {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone = "NoPhone";
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				} else {
					dataStock.agencyList.get(0).advisorList.get(0).listClient.get(clientNumber).phone = InputNewPhone;
					this.interaction.display("Voici les nouvelles informations du client");
					this.interaction.display(" ");
					readInformation(clientNumber);
				}
			}
			if (n == 7) {
				this.interaction.display("que souhaitez vous faire  ?");
				this.interaction.display("");
				this.interaction.display("   1.    Modifier les informations de " + nom + " " + prenom);
				this.interaction.display("   2.    Lire les informations de " + nom + " " + prenom);
				this.interaction.display("   3.    Supprimer " + nom + " " + prenom);
				this.interaction.display("   4.    Revenir au Menu précédent");
				this.editClient();
			}
		} else {
			this.interaction.display("Veuillez choisir un chiffre parmi la liste proposée");
			this.interaction.display("");
			this.modifyClientInformations(clientNumber);
		}

	}

	/**
	 * La méthode loadTestData() permet de récupérer les data clients qui ont été enregistrés dans la dataStock
	 * On crée un dans la dataStock une nouvelle liste d'agence que l'on nomme agencyList
	 * Une nouvelle agence est créee du nom agency avec son id et sa dte de création 
	 * Un manager est créée à l'aide de la classe Manager
	 * dans la liste d'agence on crée une nouvelle liste de conseiller que l'on nomme advisorList
	 * on créer un objet advisor de type Advisor  
	 * on complète la advisorListe avec différents client grace à la méthode add. 
	 */

	public void loadTestData() {

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

	/**
	 * La méthode readDataClient() permet d'afficher à l'utilisateur la liste de tous les client en tempsréel 
	 */
	
	public void readDataClient() {

		this.interaction.display("");
		this.interaction.display("Voici la liste des clients");
		this.interaction.display("");
		for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {

			this.interaction
					.display("               " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name
							+ " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);

		}
		this.interaction.display("");
	}

	/**
	 * La méthode chooseClient() permet à l'utilisaeur de choisir un client parmi la liste qui lui est proposée 
	 * Si la liste est vide, cela sera mentionné et l'utilisateur ne pourra plus rien faire à part créer un nouveau client 
	 * Lorsque le clent est choisi la variable clientNumber est indéxée de manière à pouvoir la réutilisée dans d'autres méthodes
	 * L'utilisateur ne pourra pas accéder à autre chose que ce qui lui est proposé
	 * si il rentre une donnée non voulu le choix de client lui sera à nouveau proposé
	 * Il est aussi possible de retourner au menu précédent en choisissant le 0
	 * Une fois le client choisi, un nouveau menu est proposé à l'utilisateur et est envoyé vers la méthode editClient()
	 */
	
	public void chooseClient() {
		if (dataStock.agencyList.get(0).advisorList.get(0).listClient.size() == 0) {
			this.interaction.display("Cette liste ne contient pas de client");
			this.interaction.display("");
			this.interaction.display("veuillez créer un nouveau client");
			this.manageMainMenu();
		} else {

			this.interaction.display("Quel client souhaitez vous sélectionner ?");
			for (int i = 0; i < dataStock.agencyList.get(0).advisorList.get(0).listClient.size(); i++) {
				this.interaction
						.display(i + 1 + " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).name
								+ " " + dataStock.agencyList.get(0).advisorList.get(0).listClient.get(i).firstname);
			}
			this.interaction.display("0 Revenir au Menu précédent");
			this.interaction.display("");

			String InputNameClient = this.interaction.readData();
			if (InputNameClient.equals("0")) {
				this.manageMainMenu();
			}
			if (InputNameClient.equals("")) {
				this.chooseClient();
			}
			else if (InputNameClient.matches("^?[1-9]*$") 
					&& Integer.parseInt(InputNameClient) < dataStock.agencyList.get(0).advisorList.get(0).listClient.size() + 1) {
				int j = Integer.parseInt(InputNameClient);
				nom = dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j - 1).name;
				prenom = dataStock.agencyList.get(0).advisorList.get(0).listClient.get(j - 1).firstname;
				this.interaction.display(
						"Vous avez choisi " + nom + " " + prenom);
				this.clientNumber = j - 1;

				this.interaction.display("");
				this.interaction.display("que souhaitez vous faire ?");
				this.interaction.display("");
				this.interaction.display("   1.    Modifier les informations de " + nom + " " + prenom);
				this.interaction.display("   2.    Lire les information de " + nom + " " + prenom);
				this.interaction.display("   3.    Supprimer " + nom + " " + prenom);
				this.interaction.display("   4.    Revenir au Menu précédent");
				this.editClient();

			} else {

				this.interaction.display("");
				this.chooseClient();

			}
		}
	}

	
	/**
	 * La méthode exitProxibanque() permet à l'utilisaeur de quitter le programme 
	 */
	
	public void exitProxibanque() {
		this.interaction.display("A bientot");
		this.running = false;
		System.exit(0);
	}

	/**
	 * La méthode manageMainMenu() permet d'orienter l'utilisateur lors de son choix dans le menu principal
	 */
	
	
	public void manageMainMenu() {
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
