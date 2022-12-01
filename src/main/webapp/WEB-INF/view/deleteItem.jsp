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
  <h1>商品削除</h1>
  
  <div class="row justify-content-center">
    <div class="col">
    <form action="" method="post">
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
       
        <tr>
          <td><c:out value="${item.id }" /></td>
          <td><c:out value="${item.name }" /></td>
          <td><c:out value="${item.price}" />円</td>
          <td><img src="uploads/<c:out value="${item.image}" />" height="180px"></td>
          <td><c:out value="${item.note}" /></td>
          <td><c:out value="${item.registered }" /></td>
          <td><c:out value="${item.updated }" /></td>
          </tr>
      
      </table>
      
      <p><input type="submit" value="削除" class="btn btn-danger">
      <a href="listItem" class="btn btn-light">キャンセル</a></p>
      </form>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script>
		$(document).ready(function() {
			$("form").submit(function() {
				return confirm("本当に削除しますか？");
			});
		});
	</script>
    </div>
  </div>
</div>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>