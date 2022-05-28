package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Client {
	   private String id_client = UUID.randomUUID().toString();//we have to use long complex ids for better security 
	   private String nom;
	   private String prenom;
	   private LocalDate dn;
	   private int ptCumul = 0; //pour le programme fidèlité on peut mettre une classe avec les méthode de rajouter les points et appliquer les promotion a la facture
	   //0 par defaut 

	   public Client(String n, String p, String dn) {//"AAAA-MM-JJ"
	      this.setNom(n);
	      this.setPrenom(p);
	      this.setDn(dn);
	   }
	   
	   public void setPtCumul(int i) {
		   this.ptCumul =+ i;
	   }
	   
	   public void setNom(String n) {
		   this.nom = n;
	   }
	   
	   public void setPrenom(String n) {
		   this.prenom = n;
	   }
	   
	   public void setDn(String dn) {
		   this.dn= LocalDate.parse(dn);
	   }
	   
	   public String getId() {
		   return this.id_client;
	   }
	   
	   public String getNom() {
		   return this.nom;
	   }
	   
	   public String getPrenom() {
		   return this.prenom;
	   }
	   
	   public LocalDate getDn() {
		   return this.dn;
	   }
	   
	   public int getPtCumul() {
		   return this.ptCumul;
	   }
	   
	   //modifier le default to string
	   
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"Nom: "+this.getNom()+"\n"+"Prenom: "+this.getPrenom()+"\n"+"age: "+ Period.between(this.getDn(), LocalDate.now()).getYears()+"\n"+"--------------------------";
		   return s;
	   }


}

