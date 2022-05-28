package view;

	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

	import model.*;

	import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.ClientCont;

	public class ClientView extends JFrame {

	   // JTextField idnetient = new JTextField(""); we don't need it 
	    JTextField nom = new JTextField();
	    JTextField prenom = new JTextField();
	    JTextField daten = new JTextField();
	    JTextField rech = new JTextField();
	    
	    JLabel n = new JLabel("Nom");
	    JLabel p = new JLabel("Prenom");
	    JLabel dn = new JLabel("Date de naissance");
	    
	    public static DefaultTableModel model = new DefaultTableModel(); 
	     
	    public static JTable affichage = new JTable(model); 
	  
	    
	    JButton ajouter = new JButton("Ajouter");
	    JButton modifier = new JButton("Modifier");
	    JButton supprimer = new JButton("Supprimer");
	    JButton rechercher = new JButton("Rechercher");

	    public ClientView() {
	    	
	        JPanel coord = new JPanel();
	        coord.setLayout(new GridLayout(5, 2));
	        
	        coord.add(n);
	        coord.add(nom);
	        coord.add(p);
	        coord.add(prenom);
	        coord.add(dn);
	        coord.add(daten);
	        coord.add(ajouter);

	        
	          model.addColumn("Id");
		      model.addColumn("Prénom");
		      model.addColumn("Nom");
		      model.addColumn("Age");
		      
		     
	     
	        
	        JPanel opp = new JPanel();
	        opp.add(modifier);
	        opp.add(supprimer);
	        
	        JPanel r = new JPanel();
	        r.setLayout(new GridLayout(1, 3));
	        r.setLayout(new GridLayout(1, 3));
	        r.add(rech);
	        r.add(rechercher);
	        
	        
	        JPanel centre = new JPanel();
	      
	        
	      

	        centre.setLayout(new BorderLayout());
	        centre.add(BorderLayout.WEST, coord);
	        centre.add(BorderLayout.CENTER, affichage);
	        centre.add(BorderLayout.SOUTH, opp);
	        centre.add(BorderLayout.NORTH,r);
	        this.getContentPane().add(BorderLayout.CENTER, centre);
	        
	        add(new JScrollPane(affichage), BorderLayout.EAST);
	        
	        this.pack();
	        
	        this.setTitle("Client manager");
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        this.setVisible(true);
	        
	        ClientCont kiki = new ClientCont(nom, prenom, daten, rech, affichage);
	        
	        ajouter.addActionListener(kiki);
	        rechercher.addActionListener(kiki);
	       supprimer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	               // check for selected row first
	               if(affichage.getSelectedRow() != -1) {
	                  // remove selected row from the model
	            	   Admin.a.removCl(affichage.getValueAt(affichage.getSelectedRow(), 0).toString(), model, affichage.getSelectedRow());
	                  
	               }
	            }
	         });
	        
	       modifier.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	               // check for selected row first
	               if(affichage.getSelectedRow() != -1) {
	            	   System.out.println(affichage.getSelectedColumn());
	            	   System.out.println(affichage.getSelectedRow());
	                 
	            	   Admin.a.changeCl(affichage.getValueAt(affichage.getSelectedRow(), 0).toString(), model, affichage.getSelectedRow(), affichage.getSelectedColumn(),affichage.getValueAt(affichage.getSelectedRow(), affichage.getSelectedColumn()).toString());
	                  
	                
	               }
	            }
	         });
	        
	  }
	    
	   

	    static public void main(String[] args) {
	        ClientView g = new ClientView();
	    
	    }


	}


