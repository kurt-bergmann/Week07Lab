/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import models.Role;
/**
 *
 * @author Kurt
 */
public class User {
    private String email = "eMaIl";
    private String first = "fIrSt";
    private String last = "lAsT";
    private String password = "pAsSwOrD";
    private Role role;
    
    
    public User(){
    }
    
    public User(String email, String first, String last, String password, Role role){
       this.email = email;
       this.first = first;
       this.last = last;
       this.password = password;
       this.role = role;
    }
    
    
    public String getFirst(){
        return first;
    }
    
    public String getLast(){
    return last;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Role getRole(){
        return role;
    }
}
