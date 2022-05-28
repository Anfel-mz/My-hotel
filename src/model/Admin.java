package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.ChambreView;
import view.ClientView;

public class Admin {
	
 public static Admin a = new Admin();
	                //notre base de données 
	 private ArrayList<Chambre> rooms = new ArrayList<Chambre>();
	 private ArrayList<Client> clients = new ArrayList<Client>();
	 private ArrayList<Reservation> reservations= new ArrayList<Reservation>();
	 private ArrayList<Sejour> sejours= new ArrayList<Sejour>();
	 private ArrayList <Sejour> sejourHistorique = new ArrayList<Sejour>();
	    
	    //////////////////////////////////////////////////////////////
	    /////////////////  GESTION DES CHAMBRES /////////////////////
	    ////////////////////////////////////////////////////////////

	 /////////////////////////////////////////ajouter une chambre//////////////////////////////////////////////////////////
	 public void addRoom(Chambre c) {
		 rooms.add(c);
	 }

	    public void addRoom(int etage, char type) {
	    	Chambre c = new Chambre( etage, type);
	       rooms.add(c);
	    }
	    
	    public void addRoom(int etage, String type) {
	    	Chambre c = new Chambre( etage, type);
	       rooms.add(c);
	    }
	    
	    public void addRoom(int etage, String type, int prix) {
	    	Chambre c = new Chambre( etage, type, prix);
	       rooms.add(c);
	    }
	    
	 
	   
/////////////////////////////////////////////afficher une chambre/////////////////////////////////////////////////////////////

	    public void showRoom() { //si on ne précise pas les paramètres on affiche tous
	    	for(Chambre c : rooms) {
	    		System.out.println(c);	
	    	}
   
	    }
	    
       public void showRoom(DefaultTableModel model) { //valide
	    	
	    	for (Chambre c : rooms) {
	    		 
	    		model.addRow(new Object[]{c.getId(), c.getEtage(),c.getType(), c.getPrix()});
	    		
		    	   }
	    	
	    }
	    
	    //afficher une chambre à partir de son num ou etage
	    public void showRoom(int n, DefaultTableModel model) {
	    	for(Chambre c : rooms) {
	    		if(n == c.getId()) {
	    			model.addRow(new Object[]{c.getId(), c.getEtage(),c.getType(), c.getPrix()});
	    			break;//pas la peine de continuer la boucle pour le reste des elements
	    		}
	   }
	  }
	    
	    //afficher les chambres dans un étage
	    public void showRoom(String e,DefaultTableModel model) { //pour le premier int on met juste un 0, it will be ignored anyways
	    	int etage ;
	    	
	    		 try {
	     		 etage = Integer.parseInt(e);
	     		for(Chambre c : rooms) {
		    		if(etage == c.getEtage()) {
		    			model.addRow(new Object[]{c.getId(), c.getEtage(),c.getType(), c.getPrix()});
		    			
		    		}
		    }
	   
	     		   }
	     		   catch(NumberFormatException e1){
	     		   }
	     		   
	    	
	    	
	    	}
	  
	    //afficher les chambres d'un type 
	    public void showRoom(char t, DefaultTableModel model) {
	    	for(Chambre c : rooms) {
	    		if(t == c.getType()) {
	    			model.addRow(new Object[]{c.getId(), c.getEtage(),c.getType(), c.getPrix()});
	    		}
	    }
	    }
	  
	    //////////////////////////////////////////supprimer une chambre ///////////////////////////////////////////////////////
	    public void removRoom(int i,DefaultTableModel model, int selecRow) {
	    	for(Chambre c : rooms) {
	    		if(i == c.getId()) {
	    			rooms.remove(c);
	    			model.removeRow(selecRow);
	    			break;//pas la peine de continuer la boucle pour le reste des elements
	    		}
	    	}
	    }
	    
	    
	    /////////////////////////////////récupérerune chambre à partir de son num///////////////////////////////////////
	    //fonction d'aide
	    private Chambre getRoom(int n) {
	    	Chambre ch = new Chambre (444, 'W');
	    	for(Chambre c : rooms) {
	    		if(c.getId() == n)return c;
	    	}
	    	System.out.println("error getting room");
	    	return ch;
	    }
	    
	    
	    public void changeRoom(int id, DefaultTableModel model, int selecRow, int selecColum, String t) { //valide
	    	for(Chambre r : rooms) {
	    		if(r.getId() == id) {
	    			
	    			
	    			if(selecColum == 1) {
	    				r.setEtage(Integer.parseInt(t));
	    				
	    				System.out.println(r);
	    				model.setValueAt(t, selecRow, selecColum);
	    				
	    			}else if(selecColum == 2){
	    				r.setType(t.toUpperCase().charAt(0));;
	    			
	    				System.out.println(r);
	    				model.setValueAt(t, selecRow, selecColum);
	    			}else if(selecColum == 3) {
	    				r.setPrix(Integer.parseInt(t));;
	    				
	    				System.out.println(r);
	    				model.setValueAt(t, selecRow, selecColum);
	    			}
	    			
	    			break;//sortir de la boucle pas la peine de continuer le reste 
	    		}
	    	}
	    }
	   
	    ////////////////////////////////////////////////////////////////
	    ///////////////// GESTION DES CLIENTS /////////////////////
	    ////////////////////////////////////////////////////////////////

	    /////////////////////////////////////////// ajouter un client////////////////////////////////////////////////////////////////
	    public void addCl(Client cl) { 	//valide
	       clients.add(cl);
	    }
	    
	    public void addCl(String n, String p, String dn) {//valide
	    	Client cl = new Client(n, p , dn);
		       clients.add(cl);
		    }
	 

	    //////////////////////////////////////////////////////////afficher les clients//////////////////////////////////////////////
	    //show all clients
	    public void showCl() { //valide
	    	
	    	for (Client c : clients) {
	    		 
		    		   System.out.println(c);
		    	   }
	    	
	    }
	    
        public void showCl(DefaultTableModel model) { //valide
	    	
	    	for (Client c : clients) {
	    		 
	    		model.addRow(new Object[]{c.getId(), c.getNom(),c.getPrenom(), Period.between(c.getDn(), LocalDate.now()).getYears()});
	    		
		    	   }
	    	
	    }
	 
	    
	    // afficher les clients à partir d'un nom et un prénom (on peut rajouter avec le nom ou prénom seulement)

	    public void showCl(String clientNom, DefaultTableModel model) { //valide
	    
	       for (Client c : clients) {
	    	   if(c.getNom().equalsIgnoreCase(clientNom) || c.getPrenom().equalsIgnoreCase(clientNom) || c.getId().equalsIgnoreCase(clientNom) ){
	    		   
	    		   model.addRow(new Object[]{c.getId(), c.getNom(),c.getPrenom(), Period.between(c.getDn(), LocalDate.now()).getYears()});
		    		
	    	   }
	     
	      }
	      
	    }
	    
	    //afficher les clients en fonction de leurs age 
	    
	    public void showCl(int age, DefaultTableModel model) {//valide
	    	
		       for (Client c : clients) {
		    	   int clage = Period.between(c.getDn(), LocalDate.now()).getYears();
		    	   if(clage == age) {
		    		  
		    		   model.addRow(new Object[]{c.getId(), c.getNom(),c.getPrenom(), Period.between(c.getDn(), LocalDate.now()).getYears()});
			    	
		    	   }
		    	   
		       } 
		    }
  
	    //////modifier un client pour l'interface
	    
	    public void changeCl(String id, DefaultTableModel model, int selecRow, int selecColum, String t) { //valide
	    	for(Client c : clients) {
	    		if(c.getId().equals(id)) {
	    			
	    			
	    			if(selecColum == 1) {
	    				c.setPrenom(t);
	    				
	    				System.out.println(c);
	    				model.setValueAt(t, selecRow, selecColum);
	    				
	    			}else if(selecColum == 2){
	    				c.setNom(t);
	    			
	    				System.out.println(c);
	    				model.setValueAt(t, selecRow, selecColum);
	    			}else if(selecColum == 3) {
	    				c.setDn(t);
	    				
	    				System.out.println(c);
	    				model.setValueAt(t, selecRow, selecColum);
	    			}
	    			
	    			break;//sortir de la boucle pas la peine de continuer le reste 
	    		}
	    	}
	    }

	    
	    //////////////////////////////////////////////supprimer des clients///////////////////////////////////////////////////
	    //supprimer un client à partir son id 
	    
	    public void removCl(String id, DefaultTableModel model, int selecRow) { //valide
	    	for(Client c : clients) {
	    		if(c.getId().equals(id)) {
	    			suppMessage(c);
	    			model.removeRow(selecRow);
	    			break;//sortir de la boucle pas la peine de continuer le reste 
	    		}
	    	}
	    }
	    
	    
	    
	    //supprimer un client à partir son nom et prénom 
	    public void removCl (String n,String p) {//valide
	    	for(Client c : clients) {
	    		if(c.getNom().equals(n) && c.getPrenom().equals(p) ) {
	    			suppMessage(c);
	    		}
	    	}
	    }
	    
	    //fonction d'affichage du message de confirmation avant de supprimer
	    private void suppMessage(Client c){//valide
	    	 String answr = JOptionPane.showInputDialog("do you really want to remove client " + c.getNom()+" "+c.getPrenom()+" ? (Y to confirm N to cancel)")	;
	 		if(answr.equalsIgnoreCase("Y")) {
	 			JOptionPane.showMessageDialog(null, c.getNom()+" "+c.getPrenom() +" is removed.");
	 			clients.remove(c);
	 		}else if(answr.equalsIgnoreCase("N")) {
	 			JOptionPane.showMessageDialog(null,c.getNom()+" "+c.getPrenom() +" is not removed.");
	 		}else {
	 			suppMessage(c);
	 		}
	        
	    }
	    
	    //fonction aide récupérer un client à partir de son id
	    private Client getClient(String id) {//valide
	    	
	    	Client cl = new Client("error", "error",LocalDate.now().toString());
	    	for(Client c : clients) {
	    		if(c.getId().equals(id)) {
	    			return c;
	    		}
	    	}
	    	System.out.println("error getting client");
	    	return cl;
	    }
	    
	    
	  

	    ////////////////////////////////////////////////////////////////
	    ///////////////// GESTION DES RESERVATIONS /////////////////////
	    ////////////////////////////////////////////////////////////////
	    
	    ///////////////////////////////////////////ajouter des reservations////////////////////////////////////////////////

 //ajouter une reservation 
	    public void addRes(Reservation r) {
	    	if(roomIsDispo(getRoom(r.getRoom()), r.getDeb(), r.getFin()) ){
	    		reservations.add(r);
	    		//this.synchroTables();
	    	}else {
	    		System.out.println("chambre n'est pas disponible");
	    	}
	    }
	    
	    public void addRes(Client cl, Chambre c, String deb, String fin) {
	    	if(roomIsDispo(c, deb,fin)) {
	    	Reservation r = new Reservation(cl.getId(), c.getId(), deb,fin);
	    	reservations.add(r);
	    	this.synchroRes();
	    	} else {
	    		System.out.println("chambre n'est pas disponible");
	    	}
	    }
	    
	    public void addRes(String id_cl, int num_ch, String deb, String fin) {
	    	if(roomIsDispo(getRoom(num_ch), deb,fin)) {
	    	Reservation r = new Reservation(id_cl, num_ch, deb,fin);
	    	reservations.add(r);
	    	//this.synchroTables(); 
	    	} else {
	    		System.out.println("chambre n'est pas disponible");
	    	}
	    }
	    
	    ////////////////////////////////////afficher les reservations //////////////////////////////////////////////////////
	    
	    
	    public void showRes() { //si on ne précise pas les paramètres on affiche tous
	    	if(reservations.size()!= 0) {
	    	for(Reservation r : reservations) {
	    		System.out.println(r + "ID client : "+r.getCl()+"\n"+ "Nom et prenom client : "+getClient(r.getCl()).getNom()+" "+ getClient(r.getCl()).getPrenom()+"\n"+"num de chambre : "+ r.getRoom()+"\n"+"Type de chambre : " + getRoom(r.getRoom()).getType() + "\n"+"-----------------------------------");	
	    	}
	    	}else {
	    		System.out.println("il n'y a pas de reservations");
	    	}
   
	    }
	    
	    //afficher les reservation à partir de leurs id
	    public void showRes(String id) { 
	    	for(Reservation r : reservations) {
	    		if(r.getId().equals(id))
	    			System.out.println(r + "ID client : "+r.getCl()+"\n"+ "Nom et prenom client : "+getClient(r.getCl()).getNom()+" "+ getClient(r.getCl()).getPrenom()+"\n"+"num de chambre : "+ r.getRoom()+"\n"+"Type de chambre : " + getRoom(r.getRoom()).getType() + "\n"+"-----------------------------------");	
	    	    }
   
	    }
	    
	    
	    //afficher les reservation à partir du client id
	    public void showResCl(String id_cl) { 
	    	for(Reservation r : reservations) {
	    		if(r.getCl().equals(id_cl))
	    		System.out.println(r + "ID client : "+r.getCl()+"\n"+ "Nom et prenom client : "+getClient(r.getCl()).getNom()+" "+ getClient(r.getCl()).getPrenom()+"\n"+"num de chambre : "+ r.getRoom()+"\n"+"Type de chambre : " + getRoom(r.getRoom()).getType() + "\n"+"-----------------------------------");	
	    	}
   
	    }
	    
	    //afficher une reservation à partir d'un num de chambre
	    public void showRes(int num_ch) { 
	    	for(Reservation r : reservations) {
	    		if(r.getRoom() == num_ch)
	    		System.out.println(r + "ID client : "+r.getCl()+"\n"+ "Nom et prenom client : "+getClient(r.getCl()).getNom()+" "+ getClient(r.getCl()).getPrenom()+"\n"+"num de chambre : "+ r.getRoom()+"\n"+"Type de chambre : " + getRoom(r.getRoom()).getType() + "\n"+"-----------------------------------");	
	    	}
	    }
	    
	    
	    //fonction d'aide qui retourne un array des chambres disponible en fonction de leurs type
	    private ArrayList<Chambre> chambreDispo(String deb, String fin, char type){
	 	   ArrayList <Chambre> ch = new ArrayList <Chambre>();
	    	for(Chambre c : rooms) {
	    		if(roomIsDispo(c,deb,fin) && c.getType() == type) {
	    			ch.add(c);
	    		}
	    	}
	    	
	    	return ch;
	    }
	    
	  //fonction d'aide qui retourne un array des chambres disponible en fonction de just une date de deb et fin
       private ArrayList<Chambre> chambreDispo(String deb, String fin){
    	   ArrayList <Chambre> ch = new ArrayList <Chambre>();
	    	for(Chambre c : rooms) {
	    		if(roomIsDispo(c,deb,fin)) {
	    			ch.add(c);
	    		}
	    	}
	    	return ch;
	    }
       
       //fonction d'aide vérifier si une chambre est dispo
       private boolean roomIsDispo(Chambre ch, String deb, String fin) {
    	   boolean b = true;
    	   LocalDate d_deb = LocalDate.parse(deb);
	       LocalDate d_fin = LocalDate.parse(fin);
	       
	       //on vérifie dans la table des sejours en cours
	       
	       for(Sejour r : sejours) {
    		   if(r.getRoom() == ch.getId()) {
    			   if(d_deb.isBefore(LocalDate.parse(r.getDeb())) && (d_fin.isBefore(LocalDate.parse(r.getDeb()))||d_fin.equals(LocalDate.parse(r.getDeb())))) {
    		    		b = true;
    		    	}else if((d_deb.isAfter(LocalDate.parse(r.getFin())) || d_deb.equals(LocalDate.parse(r.getFin())))&& d_fin.isAfter(LocalDate.parse(r.getFin()))) {
    		    		b = true ;
    		    	} else {
    		    		return false;
    		    	}
    		   }
    	   }
	       
	       //et on vérifie aussi dans la table des reservations 
    	   for(Reservation r : reservations) {
    		   if(r.getRoom() == ch.getId()) {
    			   if(d_deb.isBefore(LocalDate.parse(r.getDeb())) && (d_fin.isBefore(LocalDate.parse(r.getDeb()))||d_fin.equals(LocalDate.parse(r.getDeb())))) {
    		    		b = true;
    		    	}else if((d_deb.isAfter(LocalDate.parse(r.getFin())) || d_deb.equals(LocalDate.parse(r.getFin())))&& d_fin.isAfter(LocalDate.parse(r.getFin()))) {
    		    		b = true ;
    		    	} else {
    		    		return false;
    		    	}
    		   }
    	   }
    	   
    	 return b;
       }
       
       
       
       //afficher les chambres dispo
       
       public void showDispo(String deb, String fin) { //valide
    	 for(Chambre ch : chambreDispo(deb,fin)) {
    		 System.out.println(ch);
    	 }
    	   
       }
       
       public void showDispo(String deb, String fin, char type) { //valide
    	   for(Chambre ch : chambreDispo(deb,fin, type)) {
      		 System.out.println(ch);
      	 }
       }
       
       //////////////////////////////////annuler/supp une reservation ///////////////////////////////////////////////////
       
       //annuler une reservation à partir de l'id
       public void annulRes(String id) {//valide
    	   for(Reservation r : reservations) {
    		   if(r.getId() == id) {
    			   reservations.remove(r);
    			   break;
    		   }
    		 
    	   }
       }
       
       
       public void annulRes(Reservation res) {//valide
    	   for(Reservation r : reservations) {
    		   if(r.getId().equals(res.getId())) {
    			   reservations.remove(r);
    			   break;
    		   }
    		 
    	   }
       }
       
       public void annulRes(int num_ch, String deb, String fin) { //valide
    	   for(Reservation r : reservations) {
    		   if(r.getRoom() == num_ch && r.getDeb().toString().equals(deb) && r.getFin().toString().equals(fin)) {
    			   reservations.remove(r);
    			   break;
    		   }
    		  
    	   }
       }
       
       //fonction de synchronisation des table faut les synchroniser au moins une fois par jour et à l'ajout de chaque reservation
     
    /*   public void synchroTables() {
    	   LocalDate d =  LocalDate.now();
    	   
    	   //synchro les reservations 
    	   for(Reservation r : reservations) {
    		   //si la reservation n'est pas annuler avant 4jours du debut elle devient un séjour 
    		if(ChronoUnit.DAYS.between( LocalDate.parse(r.getDeb()),d) >= (-4) && ChronoUnit.DAYS.between( LocalDate.parse(r.getDeb()),d) <=0) {
    			this.addSej(r);//add séjour 
    			this.addClientPt(r); //on ajoute les points à notre client
    			this.annulRes(r); //on supprime la reservation de notre bd
    		}
    	   }
    	   
    	   //synchro les séjours
    	   for(Sejour s : sejours) {
    		   //si le séjour est finie on l'enlève de notre bd de séjours et on l'ajoute à l'historique
    		   if(LocalDate.parse(s.getFin()).isBefore(d)) {
    			   sejourHistorique.add(s); 
    			   removeSej(s);
    			   
    		   }
    	   }
    	   
    	   
       }*/
       
       public void synchroRes() {
    	   LocalDate d =  LocalDate.now();
    	   
    	   //synchro les reservations 
    	   if (reservations.size() != 0) {
    	   for(Reservation r : reservations) {
    		   //si la reservation n'est pas annuler avant 4jours du debut elle devient un séjour 
    		if((ChronoUnit.DAYS.between( LocalDate.parse(r.getDeb()),d) >= (-4) )&& (ChronoUnit.DAYS.between( LocalDate.parse(r.getDeb()),d) <=0)) {
    			this.addSej(r);//add séjour 
    			this.addClientPt(r); //on ajoute les points à notre client
    			this.annulRes(r); //on supprime la reservation de notre bd
    		}
    	   }
       }
       }
        
       //ajouter les points fidelite au client une fois sa reservation devient un sejour 
        private void addClientPt(Reservation s) {
    	   int days = (int) s.getDays();
    	   char typeRoom = getRoom(s.getRoom()).getType() ;
    	   
    	   switch (typeRoom) {
       	case 'D' : getClient(s.getCl()).setPtCumul(3 * days); break;
       	case 'S' : getClient(s.getCl()).setPtCumul(1 * days); break;
       	case 'N' : getClient(s.getCl()).setPtCumul(5 * days); break;
       	case 'P' : getClient(s.getCl()).setPtCumul(6 * days); break; 
       	default : System.out.println("error : unmatched room type"); ;
       	}
         }
       
                  ////////////////////////////////////////////////////////////////
                  ///////////////// GESTION DES SEJOURS /////////////////////////
                 ////////////////////////////////////////////////////////////////
       
       
       //////////////////////////////////////////////ajoter un sejour////////////////////////////////////////////
       private void addSej(Reservation r) {//private car on a pas le droit de l'utiliser elle sera automatiquement appeler lors de la synchro des tables
    	   Sejour s = new Sejour(r.getCl(), r.getRoom(), r.getDeb(), r.getFin()); //creer un objet sejour
    	   s.setId(r.getId()); //lui donner le meme id que la reservation
    	   s.setBillRoom(getPrix(r)); //update la facture de la chambre
    	   sejours.add(s); //l'ajouter à notre table
       }
       
       //fonction d'aide
       private long getPrix(Reservation r) {
    	   return r.getDays() * getRoom(r.getRoom()).getPrix();
       }
       
       /////////////////////////////////////////supprimer un sejour/////////////////////////////////////////////////////
       private void removeSej(Sejour s) {//private car on l'uilise que dans la synchro
    	   for(Sejour sej : sejours) {
    		   if(s.equals(sej)) {
    			   sejours.remove(sej);
    		   }
    	   }
       }
       
       
       ///////////////////////// //afficher le tableau d'historique des sejours de l'id client/////////////////////////////////////////
       public ArrayList<Sejour> historiqueSejour(String id_cl) {
    	   ArrayList<Sejour> his = new ArrayList<Sejour>();
    	 //on cherche dans les ancients sejours
    	   for(Sejour s : sejourHistorique) {
    		   if(s.getCl().equals(id_cl)) his.add(s);
    	   }
    	   
    	 //on cherche aussi dans les sejours en court
    	   for(Sejour s : sejours) {
    		   if(s.getCl().equals(id_cl)) his.add(s);
    	   }
    	   
    	   return his;
       }
       
       //afficher le tableau d'historique des sejours d'un client
       public ArrayList<Sejour> historiqueSejour(Client cl) {
        ArrayList<Sejour> his = new ArrayList<Sejour>();
        
        //on cherche dans les ancients sejours
        for(Sejour s : sejourHistorique) {
 		   if(s.getCl().equals(cl.getId())) his.add(s);
 	   }
        
        //on cherche aussi dans les sejours en court
    	   for(Sejour s : sejours) {
    		   if(s.getCl().equals(cl.getId())) his.add(s);
    	   }
    	   
    	   return his;
       }

       /////////////////////////////afficher les prochaine reservations d'un client/////////////////////////////////////////////////
       public ArrayList<Reservation> nextRes(String id_cl) {
    	   ArrayList<Reservation> his = new ArrayList<Reservation>();
    	   
    	   for(Reservation s : reservations) {
    		   if(s.getCl().equals(id_cl)) his.add(s);
    	   }
    	   
    	   return his;
       }
       
       
      public ArrayList<Reservation> nextRes(Client cl) {
        ArrayList<Reservation> his = new ArrayList<Reservation>();
    	   
    	   for(Reservation s : reservations) {
    		   if(s.getCl().equals(cl.getId())) his.add(s);
    	   }
    	   
    	   return his;
       }
      
      ////////////////////////////////////////////////facture/////////////////////////////////////////////////////////////
       
     
      //fonction d'aide pour l'affichage de la facture
       private void affichage (float conso, float ser, float room, int ptCumul, int promo, float totale) {
    	   System.out.println("facture consomation : " + conso);
		   System.out.println("facture services : " + ser);
		   System.out.println("facture chambre : "+ room);
		   System.out.println("---------------------------------");
		   System.out.println("points cumuler : "+ ptCumul);
		   System.out.println("promo - "+promo+ "% sur consommation et services");
		   System.out.println("Totale à payer: " + totale);
       }
       
       
       //afficher la facture
       public void showFacture(Sejour s) {
    	
    	   if (getClient(s.getCl()).getPtCumul() >= 600) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 20, getFacturePromo(s));
    	   } else if(getClient(s.getId()).getPtCumul()>= 300 && getClient(s.getId()).getPtCumul()< 600) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 20, getFacturePromo(s));
    	   } else if(getClient(s.getId()).getPtCumul()>= 100 && getClient(s.getId()).getPtCumul()< 300) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 10, getFacturePromo(s));
    	   }else {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 0, getFacturePromo(s));
    	   }
           
    	   
       }
       
       //afficher la facture à partir de l'id sejour
       public void showFacture(String id) {
       	
    	   for(Sejour s : sejours) {
    		   if(s.getId().equals(id)) {
    	   if (getClient(s.getCl()).getPtCumul() >= 600) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 20, getFacturePromo(s));
    	   } else if(getClient(s.getId()).getPtCumul()>= 300 && getClient(s.getId()).getPtCumul()< 600) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 20, getFacturePromo(s));
    	   } else if(getClient(s.getId()).getPtCumul()>= 100 && getClient(s.getId()).getPtCumul()< 300) {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 10, getFacturePromo(s));
    	   }else {
    		   affichage(s.getBillConso(), s.getBillSer(), s.getBillRoom(),getClient(s.getCl()).getPtCumul(), 0, getFacturePromo(s));
    	   }
    	   
    	   }
    	   }
           
    	   
       }
       
       ////////////////////////////////////////////////////////promo//////////////////////////////////////////////////////////////////
           
       //récuperer le prix à payer 
       public float getFacturePomo(int num_ch) {
    	   for (Sejour s : sejours) {
    		   if(s.getRoom() == num_ch) {
    			   getFacturePromo(s);
    			   break;
    		   }
    	   }
    	   
    	   System.out.println("error : unmatched room");
		return 0;
       }
       
       //récuperer la facture à payer pour un client
       public float getFacturePomo(String id_cl) {
    	   for (Sejour s : sejours) {
    		   if(s.getCl().equals(id_cl)) {
    			   getFacturePromo(s);
    			   break;
    		   }
    	   }
    	   System.out.println("error : unmatched client");
		return 0;
       }
       
       //récuperer le prix d'un sejour
       private float getFacturePromo (Sejour s) {
    	   float prix ; //prix gagner de la promo 
    	   float conso =s.getBillConso();
    	   float ser = s.getBillSer();
    	   float room = s.getBillRoom();
    	   float full = s.getFullBill();
    	   
    	   //promo -20% conso et services + -10% de la chambre
    	   if (getClient(s.getCl()).getPtCumul() >= 600) {
    		   prix = (float) ((0.2 * (conso + ser)) + (0.1 * room));
    		   
    		   //promo -20% conso et services 
    	   } else if(getClient(s.getId()).getPtCumul()>= 300 && getClient(s.getId()).getPtCumul()< 600) {
    		   prix = (float) (0.2 * (conso+ser));
    		   
    		   //-10% conso et services 
    	   } else if(getClient(s.getId()).getPtCumul()>= 100 && getClient(s.getId()).getPtCumul()< 300) {
    		   prix = (float) (0.2 * (conso+ser));
    	   }else {
    		   prix = 0;
    	   }
    	   
    	   return full - prix;
       }
     
       

       ////////////////////////////////////////////////////////////////
       ///////////////// GETTERS //////////////////////////
      ////////////////////////////////////////////////////////////////
   	public ArrayList<Reservation> getReservations(){
   		return this.reservations;
   	}
   	
	public ArrayList<Chambre> getRooms(){
   		return this.rooms;
   	}
	
	public ArrayList<Client> getClients(){
   		return this.clients;
   	}
   
	public ArrayList<Sejour> getSejours(){
   		return this.sejours;
   	}
	

	

}

