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
 
	
<main>
    <div class="logout">
       <p>ログアウトしました</p>
          <p> <a href="top" class="btn btn-outline-primary">トップへ戻る</a></p>
    </div>

 </main>
<footer>
<div class="fixed-bottom">
<div class="container-fluid bg-light text-dark text-center pt-4 pb-2">
    <p><small> Myshop</small></p> 
   </div>
   </div>    
   </footer> 
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>