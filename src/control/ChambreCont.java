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
        
        if(((JButton)e.getSource()).getText().equals("Rechercher")) {
        	if(recherche.isEmpty()) {
     		   ClientView.model.setRowCount(0);
     		  Admin.a.showRoom(ChambreView.modelRoom);
     		   
     	   }
        }  
       }  
}
