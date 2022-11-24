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
    <div class="top">
        <img src="image/top1.jpg" >
    </div>

<div id="column" class="item">

<ul>
<c:forEach items="${itemList}" var="item">
<li><a href="itemDetail?id=<c:out value="${item.id}" />"><img src="uploads/<c:out value="${item.image}" />" height="180px"></a>
  <p><c:out value="${item.name }" /> </p>
  <p><c:out value="${item.price}" />円 </p>
</li>
  </c:forEach>
</ul>
</div>    
</main>    
<footer>
<div class="container-fluid bg-dark text-light text-center pt-4 pb-2">
    <p><small> Myshop</small></p>    
   </div>
   </footer> 
</body>
</html>