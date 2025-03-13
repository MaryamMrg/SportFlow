
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page import="org.example.sportflow.bean.Entraineur" %>
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
    <h2 class="text-center mb-4">Update Entraineur</h2>

    <%
        Entraineur entraineur = (Entraineur) request.getAttribute("entraineur");
    %>

    <form action="EntraineurServlet" method="post">
        <input type="hidden" name="id_E" value="<%= entraineur.getE_id() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="name" value="<%=entraineur.getName() %>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="specialite" value="<%=entraineur.getSpecialite() %>" required />
        </div>


        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="EntraineurServlet" class="btn btn-secondary">  list of entranieur</a>
</div>

</body>
</html>
