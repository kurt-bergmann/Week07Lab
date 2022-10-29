/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;
/**
 *
 * @author Kurt
 */
public class UserDB {
    
    
    public void delete(User user)throws Exception{

        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE email=?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    
    public void update(User user)throws Exception{
         ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET first_name=?, last_name=?, password=?, role=? WHERE email=?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getFirst());
            ps.setString(2, user.getLast());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRole().getID());
            ps.setString(5, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    
    
    }
    
    
    public void insert(User user)throws Exception{
      
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (email, first_name, last_name, password, role) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirst());
            ps.setString(3, user.getLast());
            ps.setString(4, user.getPassword());
            ps.setString(5, ""+user.getRole().getID());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }  
        
    }
    
    
    public List<User> getAll () throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user";
        
         try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            while (rs.next()) {

                String email = rs.getString(1);
                String first = rs.getString(2);
                String last = rs.getString(3);
                String password = rs.getString(4);
                Role role = new Role(rs.getInt(5));
                
                User user = new User(email, first, last, password, role);
                
                users.add(user);
            }
         } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
     
        return users;
    }
        
    
    
}
