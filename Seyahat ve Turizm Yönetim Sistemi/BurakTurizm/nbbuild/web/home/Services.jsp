<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="Home.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hizmetler</title>
</head>
<body>
<%@ include file ="Header.jsp" %>
<div id="sec">
	<h3 style="padding-top:50px; padding-left:500px;">Hizmetler</h3>
	<div id="matter" style="padding:30px 80px;">
	<table class="table table-striped">
	<tr>
	<td><b>Paketler</b></td>
	<td>Kendi paketinizi dilediginiz yerle secebilirsiniz</td>
	</tr>
	<tr>
	<td width="20%"><b>Otel ve Odalar</b></td>
	<td>Farkli otel turlerine sahibiz, her otelde klimali veya klima olmayan Odalar , 
            Tek ve Cift kisilik oda gibi farkli boyutlarda odalarimiz var. 
            Odayi istediginiz zaman degistirebilir veya iptal edebilirsiniz.
	</td>
	</tr>
	<tr>
	<td><b>Yemek</b></td>
	<td>
	Hem Sebze hem de Sebze olmayan farkli yiyecek turleri sagliyoruz.
	</td>
	</tr>
	<tr>
	<td><b>Ulasim</b></td>
	<td>Araba, otobus ve mini otobus gibi farkli ulasim araclarimiz var</td>
	</tr>
	</table>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>