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
  <div class="dropdown">
  <a class="btn btn- btn-sm dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false" >
   並び替え
  </a>

  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <li><a class="dropdown-item" href="orderListUser">注文者順</a></li>
    <li><a class="dropdown-item" href="orderList">注文日順</a></li>
  </ul>
</div>

  
  <div class="row">
    <div class="col">
   
      <table class="table table-bordered">
      
        <tr>
          <th> 注文No</th>
          <th>注文者</th>
          <th>商品名</th>
          <th>金額</th>
          <th>画像</th>
          <th>注文日</th>
          
        </tr>
        <c:forEach items="${orderList}" var="order">
       
        <tr>
        <td><c:out value="${order.id}" /></td>
        <td><c:out value="${order.userName}" /></td>
        <td><c:out value="${order.itemName}" /></td>
        <td><c:out value="${order.itemPrice}円" /></td>
        
        <td ><img class="itemimage" src="uploads/<c:out value="${order.itemImage}" />" ></td>
        
        <td><c:out value="${order.ordered}" /></td>
            </tr>
        </c:forEach>
       
      </table>
      </div>
     
    </div>
  </div>

<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>