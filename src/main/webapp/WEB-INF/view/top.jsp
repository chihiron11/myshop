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
		<div class="top">
			<img src="image/top1.jpg">
		</div>

		<div id="column" class="item">
		
		
			<div class="itemList">

				<ul>
					<c:forEach items="${itemList}" var="item">
						<li><a href="itemDetail?id=<c:out value="${item.id}" />"><img
								src="uploads/<c:out value="${item.image}" />"></a>
							<p>
								<c:out value="${item.name }" />
							</p>
							<p>
								<c:out value="${item.price}" />
								円
							</p></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</main>
	<footer>
		<div class="container-fluid bg-light text-dark text-center pt-4 pb-2">
			<p>
				<small> Myshop</small>
			</p>
		</div>
	</footer>
	<script src="js/jquery-3.6.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>