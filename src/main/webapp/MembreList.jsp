<%@ page import="org.example.sportflow.bean.Membre" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of membres</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">membre List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date de Naissance</th>
            <th>Sport pratiqué</th>

        </tr>
        </thead>
        <tbody>
        <%
            List<Membre> membrelist = (List<Membre>) request.getAttribute("membrelist");

            for (Membre membre: membrelist) {
        %>
        <tr>
            <td><%= membre.getM_id() %></td>
            <td><%= membre.getName() %></td>
            <td><%= membre.getDatenaissance()%></td>
            <td><%= membre.getSport() %></td>

            <td>
                <a href="MembreServlet?action=update&id_M=<%= membre.getM_id() %>" class="btn btn-warning btn-sm">Update</a>
                <a href="MembreServlet?action=delete&id_M=<%= membre.getM_id()  %>" class="btn btn-danger btn-sm">Delete</a>




            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="AddMembre.jsp" class="btn btn-success">Add new Membre</a>
</div>

</body>
</html>
