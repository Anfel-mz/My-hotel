package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;
import view.ChambreView;
import view.ClientView;

import javax.swing.*;


public class ChambreCont implements ActionListener {

JTextField netage;
JTextField type;
JTextField price;
JTextField rech; 


    public ChambreCont(JTextField netage,JTextField type, JTextField price, JTextField r){
 
   this.netage = netage;
   this.price = price;
   this.type = type;
   this.rech = r;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	String numEtage = (String)(this.netage.getText());
        String ty = (String)(this.type.getText());
        String prix = (String)(price.getText());
        String recherche = (String)(this.rech.getText());
    
        
        //ajouter button
        if(((JButton)e.getSource()).getText().equals("Ajouter")){
        if(prix.isEmpty() || prix.equals("")) {
        	Chambre ch = new Chambre(Integer.parseInt(numEtage), ty);
        	 Admin.a.addRoom(ch);
        	 Admin.a.showRoom();
        	netage.setText("");
        	type.setText("");
        } else {
        	Chambre ch = new Chambre(Integer.parseInt(numEtage), ty, Integer.parseInt(prix));
        	 Admin.a.addRoom(ch);
        	//this.admin.showRoom();
        	netage.setText("");
        	type.setText("");
        	price.setText("");
        }
      }
        
        
        //rechercher button
        
        if(((JButton)e.getSource()).getText().equals("Rechercher")){
            
     	   if(recherche.isEmpty()) {
     		   ChambreView.modelRoom.setRowCount(0);
     		  Admin.a.showRoom(ChambreView.modelRoom);
     		   
     	   } else {
      		  
     		   try {
     			   int num = Integer.parseInt(recherche);
     			   ClientView.model.setRowCount(0);
     			   Admin.a.showRoom(num, ChambreView.modelRoom);
     			  
     		   }
     		   catch(NumberFormatException e1){
     			   String[] splited = recherche.split("\\s");
     			   ClientView.model.setRowCount(0);
     			   
     			   for(int i = 0; i< splited.length; i ++) {
     				   if(splited[i].equals("etage")) {
     					   i++;
     					  Admin.a.showRoom(splited[i], ClientView.model);
     					  
     				   } else {
     					  Admin.a.showRoom(splited[i].toUpperCase().charAt(0), ClientView.model);
     				   }
     				  
     			   }
     			   
     		   }
     		   
      	   }
       } 
       }  
}
