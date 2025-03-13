<%@ page import="org.example.sportflow.bean.Entraineur" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of membres</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Entraineur List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Specialité</th>


        </tr>
        </thead>
        <tbody>
        <%
            List<Entraineur> entraineurlist = (List<Entraineur>) request.getAttribute("Entraineurlist");

            for (Entraineur entraineur: entraineurlist) {
        %>
        <tr>
            <td><%= entraineur.getE_id() %></td>
            <td><%= entraineur.getName() %></td>
            <td><%= entraineur.getSpecialite()%></td>


            <td>
                <a href="EntraineurServlet?action=update&id_E=<%=entraineur.getE_id()%>" class="btn btn-warning btn-sm">Update</a>
                <a href="EntraineurServlet?action=delete&id_E=<%= entraineur.getE_id()  %>" class="btn btn-danger btn-sm">Delete</a>




            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="AddEntraineur.jsp" class="btn btn-success">Add new Entraineur</a>
</div>

</body>
</html>
