<%-- 
    Document   : users
    Created on : 28-Oct-2022, 1:03:39 PM
    Author     : Kurt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1><a href="user?action=Add">Manage Users</a></h1>
     <c:if  test = "${users.size() > 0}">
<table>   
    <tr>
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Role</th>
    </tr>
<c:forEach var="user" items="${users}">
<tr>
<td>${user.email}</td>
<td>${user.first}</td>
<td>${user.last}</td>
<td>${user.role.getName()}</td>
<td><a href="user?useremail=${user.email}&action=Update">Edit</a></td>
<td><a href="user?useremail=${user.email}&action=Delete">Delete</a></td>
</tr>
</c:forEach>
</table>
     </c:if>
        <h1>${action} User</h1>
        
        <c:if  test = "${action == 'Add'}">
        <Form action="user" method="post">
            Email:<input type="text" name="email"><br>
            First Name:<input type="text" name="first"><br>
            Last Name:<input type="text" name="last"><br>
            Password:<input type="text" name="password"><br>
            Role: 
            <select name="role">
                <option value="1">System Admin</option>
                <option value="2">Regular User</option>
            </select><br>
            
        <input type="submit" value="Add" name="action"> 
        </Form>
        </c:if>
        
        <c:if  test = "${action == 'Update'}">
        <Form action="user" method="post">
            Email:<input type="text" name="email" value="${useremail}" disabled><br>
            First Name:<input type="text" name="first" ><br>
            Last Name:<input type="text" name="last"><br>
            Password:<input type="text" name="password"><br>
            Role: 
            <select name="role">
                <option value="1">System Admin</option>
                <option value="2">Regular User</option>
            </select><br>
            
            
            
        <input type="submit" value="Update" name="action"> 
        </Form>
        </c:if>

    </body>
</html>
