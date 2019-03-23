<%-- 
    Document   : form7
    Created on : Feb 5, 2019, 2:19:45 AM
    Author     : nilayharyal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD><TITLE>Movie Store</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1>Welcome to our Movie Store</H1>
<form action="form7.jsp" method="POST">
<label>Please make your selection below</label><br><br> 
<select name="selection">
  <option value="Browse">Browse Movies</option>
  <option value="NewMovie">Add New Movie to the database</option>
</select>  
<input type="submit"  name="submit">
</form>
<% 
if(request.getParameter("selection") != null){
String selection = request.getParameter("selection");
if (selection.equals("Browse")){
    response.sendRedirect("Browse.html");
}
if (selection.equals("NewMovie")){
    response.sendRedirect("NewMovie.html");
}
}
%>
</BODY>
</HTML>