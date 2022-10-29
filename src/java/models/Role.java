/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Kurt
 */
public class Role {
    
    private String name;
    private int id;
    
    
    public Role(){
        
    }
    
    public Role(int id){
        this.id = id;
        
        if(id == 1){
            this.name = "system admin";
        } 
        else if(id == 2){
            this.name = "regular user";
        } 
        else{
            this.name = "error";
        }
        
    }
    
    
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return id;
    }
    
}
