/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata - 123180004
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {
     LoginView loginview;
    LoginModel loginmodel;
    LoginDAO logindao;
    
    public LoginController(final LoginView loginview, final LoginModel loginmodel, final LoginDAO logindao){
        this.logindao = logindao;
        this.loginmodel = loginmodel;
        this.loginview = loginview;
        
        loginview.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginview.getUsername();
                String password;
                password = loginview.getPassword();
                if(username.isEmpty() || password.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
            }else{
                    loginmodel.setLoginModel(username, password);
                    logindao.Login(loginmodel);
                    MVC mvc = new MVC();
                }
            }
        });
    }
}
