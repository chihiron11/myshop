<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Allura&display=swap" rel="stylesheet">
<header>
<div class="headtop">
<nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="top"><span style="font-size:30px">MyShop</span></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link " aria-current="page" href="top">Top</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="shopList">Shoplist</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
        

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="mypage" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <c:out value="${user.name}" />
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="mypage">マイページ</a></li>
            <li><a class="dropdown-item" href="logout">ログアウト</a></li>
           </ul>
           
        </li>

        
      </ul>
               <a href="login" class="btn btn-outline-dark">ログイン</a>
               
 <div class="new">
<a href="newMember" class="link-dark">新規会員登録はこちら</a>
</div>
<form action="search" method="post" class="search_container">
 <input type="text" size="20" name="search" placeholder="キーワードを入力">
 <input type="image" name="submit" src="image/serch.jpeg" width="16px">
</form>



    </div>
  </div>
</nav>
</div>
	</header>