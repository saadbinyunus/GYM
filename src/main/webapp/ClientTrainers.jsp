<%-- 
    Document   : userbooks
    Created on : Jan 24, 2021, 1:00:48 AM
    Author     : student
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="ryerson.ca.lab2.Trainer"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style = "color:white">Trainer Details</title>
    </head>
    <style>

body {
  background-image: url('resources/new.jpg');
}
</style>
<% 
    ArrayList<Trainer> trainers= (ArrayList)request.getAttribute("trainerInfo");
  
%>

<center><h2 style = "color:white">Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3 style = "color:white"> Here is a list of our trainers</h3></center>
<br>
<form action="HireTrainer" method="post">
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th style = "color:red"> Name </th>
<th style = "color:red"> Gender </th>
<th style = "color:red"> Specialty </th>
<th style = "color:red"> Hire Trainer </th>

</tr>

    <% for(Trainer trainer: trainers){
    %>
<tr>
<td style = "color:red"> <%=trainer.getTrainerName()%> </td>
<td style = "color:red"> <%=trainer.getGender()%></td>
<td style = "color:red"> <%=trainer.getSpecialty()%></td>
<% if (trainer.isAvailable()){
%>
<td style = "color:red"> <input type="submit" value="Hire" ></td>
<%}

else {
%>


<td style = "color:red"> "The trainer is currently unavailable."</td>
<% }}
%>
</tr>
</table>
</form>
</body>
</html>
