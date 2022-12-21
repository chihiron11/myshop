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

	<div class="top">
		<img id="image" src="image/top1.jpg">
	</div>

<div id="column" class="main">
	<div class="side">
		<ul>
		<li><a href="category?id=1">ネックレス</a></li>
		<li><a href="category?id=2">ピアス</a></li>
		<li><a href="category?id=3">リング</a></li>
		</ul>
		

	</div>
	
	<div class="itemList">
	<div class="item">
		<ul>
		<c:forEach items="${itemList}" var="item">
			<li><a href="itemDetail?id=<c:out value="${item.id}" />">
			<img src="uploads/<c:out value="${item.image}" />"></a>
				<p>
				<c:out value="${item.name }" />
				</p>
				<p>
				<c:out value="${item.price}" />円
				</p>
				</li>
		</c:forEach>
		</ul>
	</div>
	</div>
</div>
		
	
	<footer>
	<div class="foottop">
		<div class="container-fluid text-dark text-center pt-4 pb-2">
			<p>
				<small> Myshop</small>
			</p>
		</div>
		</div>
	</footer>
	
	<script src="js/jquery-3.6.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script>
$(document).ready(function () {
  let p = 1;
  function changePhoto() {
    if (p == 1) {
      $('#image').fadeOut(500, 'linear', function () {
        $(this).attr('src', 'image/shoplist3.jpg');
        $(this).fadeIn(500);
        p = 2;
      });
    }
    else {
      $('#image').fadeOut(500, 'linear', function () {
        $(this).attr('src', 'image/top1.jpg');
        $(this).fadeIn(500);
        p = 1;
      });
    }
  }
  setInterval(changePhoto, 5000);
});
</script>
</body>
</html>