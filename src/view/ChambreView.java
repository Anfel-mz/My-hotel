package view;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.*;

public class ChambreView extends JFrame {
	
	public static DefaultTableModel modelRoom = new DefaultTableModel(); 
    
    public static JTable affichageRoom = new JTable(modelRoom); 
    
   
    JTextField typeCh = new JTextField();
    JTextField n_etage = new JTextField();
    JTextField rech = new JTextField();
    JTextField prix = new JTextField();
 
    JLabel n_etagel = new JLabel("Etage");
    JLabel typel = new JLabel("Type");
    JLabel prixl=new JLabel("Prix");
    JLabel priceOfRoom=new JLabel("");
    JButton ajouter = new JButton("Ajouter");
    JButton modifier = new JButton("Modifier");
    JButton supprimer = new JButton("Supprimer");
    JButton rechercher = new JButton("Rehercher");

    

    public ChambreView() {
        Admin a=new Admin();
        JPanel infos = new JPanel();
        infos.setLayout(new GridLayout(4, 2));
     
        infos.add(n_etagel);
        infos.add(n_etage);
        infos.add(typel);
        infos.add(typeCh);
        infos.add(prixl);
        infos.add(prix);
        infos.add(ajouter);
    
        
          modelRoom.addColumn("numero de chambre");
	      modelRoom.addColumn("etage");
	      modelRoom.addColumn("type");
	      modelRoom.addColumn("prix");
        
        

        JPanel op = new JPanel();
        op.setLayout(new GridLayout(1, 2));
        op.add(modifier);
        op.add(supprimer);
        
        JPanel r = new JPanel();
        r.setLayout(new GridLayout(1, 2));
        r.add(rech);
        r.add(rechercher);
        
        JPanel centre = new JPanel();

        centre.setLayout(new BorderLayout());
        centre.add(BorderLayout.WEST, infos);
        centre.add(BorderLayout.SOUTH, op);
        centre.add(BorderLayout.CENTER, affichageRoom);
        centre.add(BorderLayout.NORTH,r);
        
        this.getContentPane().add(BorderLayout.CENTER, centre);
        add(new JScrollPane(affichageRoom), BorderLayout.EAST);
        
        this.pack();
        
        this.setTitle("Chambre manager");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setVisible(true);
 
        ChambreCont koko=new ChambreCont( n_etage, typeCh, prix, rech);
        ajouter.addActionListener(koko);
        rechercher.addActionListener(koko);
        


    }

    static public void main(String[] args) {
        ChambreView c = new ChambreView();
   
    }
 



}
