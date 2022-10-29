/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.User;
import java.util.List;
import dataaccess.UserDB;

/**
 *
 * @author Kurt
 */
public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(User user)throws Exception{
        UserDB userDB = new UserDB();
        userDB.insert(user);
        
    }

    public void update(User user)throws Exception{
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(User user)throws Exception{
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
    
}
