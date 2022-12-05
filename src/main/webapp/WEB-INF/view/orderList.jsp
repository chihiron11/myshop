<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>商品管理</title>
</head>
</head>
<body>
<c:import url="parts/header.jsp" />
<div class="container">
  <h1>注文リスト</h1>
  <p><a href="addItem" class="btn btn-primary">商品登録</a></p>
  <div class="row">
    <div class="col">
   
      <table class="table table-bordered">
      
        <tr>
          <th>注文No</th>
          <th>注文者</th>
          <th>商品名</th>
          <th>金額</th>
          <th>画像</th>
          <th>注文日</th>
          
        </tr>
        <c:forEach items="${orderList}" var="order">
        <tr>
          <td><c:out value="${order.id}" /></td>
          <td><c:out value="${userName}" /></td>
          <td><c:out value="${order.name}" /></td>
          <td><c:out value="${order.price}" />円</td>
          <td ><img class="itemimage" src="uploads/<c:out value="${order.image}" />" ></td>
         <td><c:out value="${order.ordered}" /></td>
          </tr>
        </c:forEach>
       
      </table>
      </div>
      <p><a href="addItem" class="btn btn-primary">商品登録</a></p>
    </div>
  </div>

<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>