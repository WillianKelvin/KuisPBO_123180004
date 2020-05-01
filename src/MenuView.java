
import com.mysql.jdbc.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata - 123180004
 */
public class MenuView extends JFrame {
    JLabel ljudul,ltipe,lepisode,lstatus,lrating,lgenre;
    JTextField txjudul, txtipe, txepisode, txrating, txgenre, txsearch;
    JButton bsearch, brefresh,bcreate,bupdate,bdelete,bexit;
    String [] katstatus = {"Selesai","Belum"};
    JComboBox status = new JComboBox(katstatus);
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[]={"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};
    Statement statement;
    
    public MenuView(){
        setTitle("Dashboard");
        // atur tabel
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        //atur label 
        ljudul = new JLabel ("Judul");
        ltipe = new JLabel ("Tipe");
        lstatus = new JLabel("Status");
        lepisode = new JLabel ("Episode");
        lrating = new JLabel ("Rating");
        lgenre = new JLabel ("Genre");
        
        txjudul = new JTextField("");
        txtipe = new JTextField("");
        txepisode = new JTextField("");
        txrating = new JTextField("");
        txgenre = new JTextField("");
        txsearch = new JTextField("");

        bsearch = new JButton("Search");
        brefresh = new JButton("Refresh");
        bcreate = new JButton("Create");
        bupdate = new JButton("Update");
        bdelete = new JButton("Delete");
        bexit = new JButton("Exit");
        
//        status = new JComboBox(katstatus);
        //willian
        
        setLayout(null);
        add(ljudul);
        add(ltipe);
        add(lepisode);
        add(lstatus);
        add(lrating);
        add(lgenre);
        
        add(txjudul);
        add(txtipe);
        add(txepisode);
        add(txrating);
        add(txgenre);
        add(txsearch);
        add(status);
        
        add(bsearch);
        add(brefresh);
        add(bcreate);
        add(bupdate);
        add(bdelete);
        add(bexit);
        add(scrollPane);
        
        scrollPane.setBounds(50,50,800,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ljudul.setBounds(50, 260, 50, 20);
        txjudul.setBounds(50,300, 300, 20);
        txsearch.setBounds(450, 300,150,20);
        ltipe.setBounds(50,320, 50, 20);
        txtipe.setBounds(50,350, 120, 20);
        lstatus.setBounds(250, 320, 50, 20);
        status.setBounds(250, 350, 100, 20);
        lepisode.setBounds(50, 380, 50, 20);
        txepisode.setBounds(50, 420, 120, 20);
        lrating.setBounds(250, 380, 50, 20);
        txrating.setBounds(250, 420, 100, 20);
        lgenre.setBounds(50, 450, 50, 20);
        txgenre.setBounds(50, 480, 300, 20);
        
        bsearch.setBounds(620,300,80,20);
        brefresh.setBounds(400, 480, 80, 20);
        bcreate.setBounds(500, 480, 80, 20);
        bupdate.setBounds(590, 480,80,20);
        bdelete.setBounds(680, 480, 80, 20);
        bexit.setBounds(770, 480, 60, 20);
        
        
        setSize(900,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
//    public int getNo(){
//        int i=0;
//        i++;
//        return i;
//    }
//     
//    public int getId(){
//        int j=5;
//        j++;
//        return j;
//    }
    
    public String getJudul(){
        return txjudul.getText();
    }
    
    public String getTipe(){
        return txtipe.getText();
    }
    
    public String getEpisode(){
        return txepisode.getText();
    }
    
    public String getStatus(){
        return status.getSelectedItem().toString();
        
    }
    
    public String getRating(){
        return txrating.getText();
    }
    
    public String getGenre(){
        return txgenre.getText();
    }
    
    public String getCari(){
        return txsearch.getText();
    }
    
}
