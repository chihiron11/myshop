<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <header>
	<nav class="navbar navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="top">Myshop</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link" href="news">News</a></li>
						<li class="nav-item active"><a class="nav-link" href="">Gallery</a></li>
					</ul>
                                   
				</div>
                
<!--                <a class="btn btn-light ml-lg-4 " a href="userLogin.html">ログイン</a>   --> 
			</div>
		</nav>

	</header>
<main>
  <div id="item" class="wrapper">
        <div class="item-image">
         <img src="uploads/<c:out value="${image}" />" height="500px">
        </div>
      <div class="item-info">
          <div class="item-name">
         <p><c:out value="${name }" /></p>
         <p><c:out value="${price}" />円</p>
        <p><c:out value="${note}" /></p>
      <p><a href="addItem" class="btn btn-primary">注文する</a></p>
    </div>
  </div>
  </div>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</main>
</html>