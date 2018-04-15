<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prime Number Generator</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/styles.css">


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
</head>
<%
if(request.getParameter("calculate")!=null)
{
String startRange=request.getParameter("startRange");
String endRange=request.getParameter("endRange");
String strategies=request.getParameter("strategies");
String url=request.getRequestURL().toString().substring(0,request.getRequestURL().toString().lastIndexOf('/'))+"/webapi"+"/primeNumberService"+"/"+startRange+"/"+endRange+"/"+strategies;
 System.out.println(url);
 response.sendRedirect(url);
 }
 %>
<body>
<nav class="navbar navbar-default navbar-static-top">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<h2>Prime Number Generator</h2>
</div>
</div>
</nav>
<fieldset class="panel panel-default">

<div class="panel-body">
<form method="post">
<label for="name">Start Range</label>
<div class="form-group input-group">
<input class="form-control" type="number" id="startRange" name="startRange" required/>
</div>
<label for="name">End Range</label>
<div class="form-group input-group">
<input class="form-control" type="number" id="endRange" name="endRange" required/>
</div>
<div class="form-group">
<select	class="form-control selectpicker" id="strategies" name="strategies" data-none-selected-text="">
<option value="Strategy1">Basic Algorithm</option>
<option value="Strategy2">Sieve of Eratosthenes Algorithm</option>
<option value="Strategy3">Segmented Sieve Algorithm</option>
</select>
</div>
<div>
<span class="input-group-btn">
<input class="btn btn-primary" type="submit" name="calculate" value="Calculate">
</span>
</div>
</form>
</div>
</body>
</html>