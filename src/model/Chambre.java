package model;

public class Chambre {
	private static int idCounter = 0; //generate room number
	private int num_ch;
    private int etage;
    private char type;
    int prix ;
    
    
    

  public  Chambre(int etage, char type) {
	   idCounter++;
       this.setNumCh(idCounter);
       this.setEtage(etage);
       this.setType(type);
       this.setPrix(this.getPrice());
       
        
    }
  
  public  Chambre(int etage, char type, int prix) {
	   idCounter++;
      this.setNumCh(idCounter);
      this.setEtage(etage);
      this.setType(type);
      this.setPrix(prix);

   }
    
  public  Chambre(int etage, String type) {
 	   idCounter++;
        this.setNumCh(idCounter);
        this.setEtage(etage);
        this.setType(type.toUpperCase().charAt(0));
        this.setPrix(this.getPrice());
        
         
     }
  
  public  Chambre(int etage, String type,  int prix) {
	   idCounter++;
       this.setNumCh(idCounter);
       this.setEtage(etage);
       this.setType(type.toUpperCase().charAt(0));
       this.setPrix(prix);
       
        
    }
   
  
   public int getId() {
	   return this.num_ch;
   }
   
   public int getEtage(){
	   return this.etage;
   }
   
   public char getType() {
	   return this.type;
   }
   
   
   public void setNumCh(int n) {
	   this.num_ch = n ;
   }
   
   public void setEtage(int n ) {
	   this.etage = n;
   }
   
   public void setType(char t ) {
	   this.type = t;
   }
   
   
   public void setPrix(int p) {
	   this.prix = p ;
   }
   
   
  
    
    //avoir le prix de la chambre selon le type
    private int getPrice() {
    	int p;
    	switch (this.type) {
    	case 'D' : p = 150; break;
    	case 'S' : p = 60; break;
    	case 'N' : p = 230; break;
    	case 'P' : p = 360; break; 
    	default : p = 0 ;
    	}
    	
    	return p;
    }
    
    public int getPrix() {
    	return this.prix;
    }
    
    
    
    
    public String toString() {
    	 return ("numero de chambre: " + getId() + "\n" + " etage: " + getEtage() + "\n" + " type: " + getType() + "\n" + " Prix: " + getPrix()+ "\n" +" -------------------------------");
    	   
    }

}

