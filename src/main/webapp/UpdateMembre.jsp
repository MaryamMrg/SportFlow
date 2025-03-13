
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page import="org.example.sportflow.bean.Membre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mise a jour Formulaire</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Membre</h2>

    <%
        Membre membre = (Membre) request.getAttribute("membre");
    %>

    <form action="MembreServlet" method="post">
        <input type="hidden" name="id_M" value="<%= membre.getM_id() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="name" value="<%=membre.getName() %>" required />
        </div>

        <div class="form-group">
            <input type="date" class="form-control" name="date_naissance" value="<%=membre.getDatenaissance() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="sport_pratique" value="<%=membre.getSport() %>" required />
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="MembreServlet" class="btn btn-secondary">  list of membres</a>
</div>

</body>
</html>
