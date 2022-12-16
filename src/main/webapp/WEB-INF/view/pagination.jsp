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
  <h1></h1>
 
  <div class="row">
    <div class="col">
   
      <table class="table table-bordered">
      
        <tr>
          <th>商品ID</th>
          <th>カテゴリ</th>
          <th>商品名</th>
          <th>金額</th>
          <th>画像</th>
          <th>商品説明</th>
          <th>登録日</th>
          <th>更新日</th>
          <th colspan="2">更新・削除</th>
        </tr>
        <tr>
        <td><c:out value="${totalItems}" /></td>
       </tr>
      </table>
      </div>
      <p><a href="addItem" class="btn btn-primary">商品登録</a></p>
    </div>
    <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>
  </div>

<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>