/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.UserService;
import java.util.List;
import java.util.Set;
import models.User;
import models.Role;
/**
 *
 * @author Kurt
 */
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String useremail = request.getParameter("useremail");
        session.setAttribute("useremail", useremail);
        request.setAttribute("useremail", useremail);
        
        String action = request.getParameter("action");
        if(action==null){
            action = "Add";
            request.setAttribute("action", "Add");
            
        }

        UserService us = new UserService();
         
        request.setAttribute("action", action);
        
        
        if(action.equals("Add")){
        try{
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }
}

        if(action.equals("Update")){
        request.setAttribute("email", "tester");
                    try{
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }
            

}
        
        if(action.equals("Delete")){
        request.setAttribute("action", "Add");
            
            
        String email = (String)session.getAttribute("useremail");
        String first = "";
        String last = "";
        String password ="";
        Role role = new Role(-1);
        User user = new User(email,first,last,password,role);
        request.setAttribute("action", "Update");
        
         try{
        us.delete(user);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }
            
            
            try{
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        }catch(Exception ex){
            request.setAttribute("message", ex);
            }
        }
        
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String password = request.getParameter("password");
        Role role = new Role(Integer.parseInt(request.getParameter("role")));
        HttpSession session = request.getSession();
        
        if(action.equals("Add")){
        UserService us = new UserService();
        
        User user = new User(email,first,last,password,role);
        request.setAttribute("action", "Add");
        try{
        us.insert(user);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }

        try{
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }
        
        }
        
        
        if(action.equals("Update")){
        email = (String)session.getAttribute("useremail");
        UserService us = new UserService();
        User user = new User(email,first,last,password,role);
        request.setAttribute("action", "Update");
        
         try{
        us.update(user);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }

             try{
        List<User> users = us.getAll();
        request.setAttribute("users", users);
        }catch(Exception ex){
            request.setAttribute("message", ex);
        }
            
            
        }
        
         getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }


}
