
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class LoginView extends JFrame{
    JLabel ljudul, lusername, lpassword;
    JTextField txusername, txpassword;
    JButton login;
    
    public LoginView(){
        setTitle("LOGIN");
        //label
        ljudul = new JLabel("Login Admin");
        lusername = new JLabel("Username");
        lpassword = new JLabel("Password");
        //textfield
        txusername = new JTextField("");
        txpassword = new JTextField("");
        //button
        login = new JButton("LOGIN");
        
        setLayout(null);
        add(ljudul);
        add(lusername);
        add(lpassword);
        add(txusername);
        add(txpassword);
        add(login);
        
        ljudul.setBounds(150, 50, 125, 20);
        lusername.setBounds(50, 103, 75, 20);
        lpassword.setBounds(50, 153, 75, 20);
        txusername.setBounds(150, 100, 175, 30);
        txpassword.setBounds(150, 150, 175, 30);
        login.setBounds(150, 200, 75, 30);
        
        setSize(400,350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getUsername(){
        return txusername.getText();
    }
    
    public String getPassword(){
        return txpassword.getText();
    }
}

