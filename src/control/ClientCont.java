package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Admin;
import model.Client;
import view.ClientView;

import javax.swing.*;


public class ClientCont implements ActionListener {
JTextField name;
JTextField fname;
JTextField birth;
JTextField rech; 
JTable affichage;
String selecClientId;
int selectedRow;


    public ClientCont(JTextField N,JTextField P,JTextField DN, JTextField r, JTable rsl){
    
        this.name=N;
        this.fname=P;
        this.birth=DN;
        this.rech = r;
        this.affichage= rsl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String namef=(String)(name.getText());
        String fnamef=(String)(fname.getText());
        String birthf=(String)(birth.getText());
        String recherche = (String) (rech.getText());
        
        ///ajouter buton 
       if(((JButton)e.getSource()).getText().equals("Ajouter")){
         Client cl=new Client (namef, fnamef, birthf);
     
         Admin.a.addCl(cl);
         //this.admin.showCl();
         name.setText("");
         fname.setText("");
         birth.setText("");

        
    }
       
       ///rechercher button
       if(((JButton)e.getSource()).getText().equals("Rechercher")){
         
    	   if(recherche.isEmpty()) {
    		   ClientView.model.setRowCount(0);
    		  Admin.a.showCl(ClientView.model);
    		   
    	   } else {
     		  
    		   try {
    			   int age = Integer.parseInt(recherche);
    			   ClientView.model.setRowCount(0);
    			   Admin.a.showCl(age, ClientView.model);
    			  
    		   }
    		   catch(NumberFormatException e1){
    			   String[] splited = recherche.split("\\s");
    			   ClientView.model.setRowCount(0);
    			   
    			   for(String s : splited) {
    				   Admin.a.showCl(s, ClientView.model);
    			   }
    			   
    		   }
    		   
     	   }
      }
       
 
   
     }
    
}