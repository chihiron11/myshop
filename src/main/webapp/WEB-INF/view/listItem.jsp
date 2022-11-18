<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>商品管理</title>
</head>
</head>
<body>
<div class="container">
  <h1>商品リスト</h1>
  <div class="row">
    <div class="col">
      <table class="table table-bordered">
        <tr>
          <th>商品ID</th>
          <th>商品名</th>
          <th>金額</th>
          <th>画像</th>
          <th>商品説明</th>
          <th>登録日</th>
          <th>更新日</th>
        </tr>
        <c:forEach items="${itemList }" var="item">
        <tr>
          <td><c:out value="${item.id }" /></td>
          <td><c:out value="${item.name }" /></td>
          <td><c:out value="${item.price}" />円</td>
          
          <td><img src="uploads/<c:out value="${item.image}" />" height="180px"></td>
          
          
          <td><c:out value="${item.note}" /></td>
          <td><c:out value="${item.registered }" /></td>
          <td><c:out value="${item.updated }" /></td>
        </tr>
       
        </c:forEach>
      </table>
      <p><a href="addItem" class="btn btn-primary">商品登録</a></p>
    </div>
  </div>
</div>


<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>