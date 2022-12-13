<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>Myshop</title>
</head>
<body>
	<c:import url="parts/headertop2.jsp" />

  <div class="title">
  <h1>SHOP LIST</h1>
  <div class="all">
		<div class="shoplist">
			<div class="address">
			
			<table >
			<tr>
			<td colspan="3">MyShop 東京店</td>
			</tr>
			<tr>
			<td>address </td><td>東京都新宿区新宿1-1-1<a href="https://goo.gl/maps/UisJzjqeXRmLMe9PA">map</a></td>
			
			</tr>
			<tr>
			<td>tel</td><td>03-1234-5678</td>
			</tr>
			<tr>
			<td>open</td><td>11:00～20:00</td>
			</tr>
			</table>
			
			</div>
			<div class="shoplistimg"></div>
			<img class="shoplist" src="image/shoplist1.jpg">
			</div>
			</div>
		</div>
		
		
</body>
</html>