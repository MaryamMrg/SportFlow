<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="style/AddMembre.css">
  <title>add</title>
</head>
<body>

<main>
  <section>
    <div id="form">
      <form id="form1" class="form1" action="MembreServlet" method="post">
        <h2>add membre</h2>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="name">name  </label>
            <input type="text" class="form-control" id="name" name="name" placeholder="name of membre">
          </div>
          <div class="form-group col-md-6">
            <label for="date_naissance">Date de naissance</label>
            <input type="date" class="form-control" id="date_naissance" name="date_naissance" placeholder="date de naissance">
          </div>
        </div>
        <div class="form-group">
          <div class="form-group col-md-12">
            <label for="sport_pratique">sport pratiqué</label>
            <input type="text" class="form-control" id="sport_pratique" name="sport_pratique" placeholder="sport pratiquer">
          </div>
        </div>


        <div id="btn">
          <button type="submit" class="btn btn-primary">Add membre</button>

        </div>
      </form>
    </div>
  </section>
</main>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>