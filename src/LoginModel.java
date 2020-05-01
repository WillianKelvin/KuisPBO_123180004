/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Willian Kelvin Nata -123180004
 */
public class LoginModel {
    private String username, password;
    //constructor
    public void setLoginModel(String uusername, String ppassword){
        this.username = username;
        this.password = ppassword;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

