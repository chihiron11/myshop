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
    <title>商品管理</title>
</head>
<body>
<c:import url="parts/header.jsp" />
 
	
<main>
    <div class="logout">
       <p>ログアウトしました</p>
          <p> <a href="adminLogin"  class="btn btn-outline-primary">ログイン画面に戻る</a></p>
          
    </div>

 </main>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>