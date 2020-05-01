/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata -123180004
 */
public class LoginMVC {
    LoginView loginview = new LoginView();
    LoginModel loginmodel = new LoginModel();
    LoginDAO logindao = new LoginDAO();
    LoginController Logincontroller = new LoginController(loginview, loginmodel,logindao);
}
