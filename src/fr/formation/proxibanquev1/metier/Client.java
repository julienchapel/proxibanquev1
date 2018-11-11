package fr.formation.proxibanquev1.metier;

/**
 * Cette classe defint un client via ses différent attributs 
* @author Laila_Julien
*
*/
public class Client {
   
   
   public String name;
   public String firstname;
   public String adresse;
   public String zipCode;
   public String city;
   public String phone;
   public CurrentAccount  currentAccount;
   /**
    * Ceci construit un client spécifié avce le nom, le prénom, le code postal et le numéro de téléphone.
    * @param name  est le nom du client.
    * @param firstname est le prénom du client.
    * @param adresse est l'adresse du client.
    * @param zipCode  est le code postale du client.
    * @param city  est la ville du client.
    * @param phone est le numéro de téléphone du client
    */

   public Client(String name, String firstname, String  adresse,
           String zipCode, String city, String phone) {
       
       this.name = name;
       this.firstname = firstname;
       this.adresse = adresse;
       this.zipCode = zipCode;
       this.city = city;
       this.phone = phone;
       this.currentAccount = new CurrentAccount();
       
       
   }
   /**
    * ceci construit un client spécifié avec le nom et le prénom du client
    * @param name le nom du client
    * @param firstname le prénom du client
    */

   public Client (String name, String firstname) {
       
       this.name = name;
       this.firstname = firstname;
   }
   
}
