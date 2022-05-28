package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
	int n = 0;
    private String id_res = UUID.randomUUID().toString();//we use unique ids for security
    private String id_cl; //id du client pour accéder aux info client 
    private int num_ch; //id de la chambre pour acceder aux info de la chambre 
    private LocalDate deb;
    private LocalDate fin;

    Reservation(String id_cl, int num_ch, String deb, String fin) {
      
        this.id_cl = id_cl;
        this.num_ch = num_ch ;
        if(LocalDate.parse(deb).isAfter(LocalDate.parse(fin)) || LocalDate.parse(deb).isBefore(LocalDate.now())) {
        	System.out.println("unvalid reservation dates please change and try again");
        } else {
        this.deb = LocalDate.parse(deb);
        this.fin = LocalDate.parse(fin); }
        
    }
    
    public String getId() {
    return this.id_res;
    
    }
    
    
    
    public String getDeb() {
    return this.deb.toString();	
    }
    
    public String getFin() {
        return this.fin.toString();	
        }
    
    public int getRoom() {
    	return this.num_ch;
    }
    
    public String getCl() {
    	return this.id_cl;
    }
    
    
    //modifier la chambre 
    
    public void setRoom(int n) {
    	this.num_ch = n;
    
    }
    
    public void setCl(String cl) {
    	this.id_cl = cl;
    }
    
    
    //modifier la date de réservation 
    public void setDeb(String d) {
    	this.deb = LocalDate.parse(d);
    }
    
    public void setFin(String d) {
    	this.fin = LocalDate.parse(d);
    }
    
    public String toString() {
   	 return ("reservation ID: " + getId() + "\n" + " date de debut : " + getDeb() + "\n" + " date de départ : " + getFin() + "\n" );
   	   
   }
    
    
    public long getDays() {
        return  ChronoUnit.DAYS.between(deb, fin);
     }
    
   
	
	

}
    

    


