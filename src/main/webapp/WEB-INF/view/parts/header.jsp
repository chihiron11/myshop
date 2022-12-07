<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="listItem">商品管理システム</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <a href="adminLogin" class="btn btn-outline-light">ログイン</a>
      
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
         
         <li class="nav-item">
          <a class="nav-link " aria-current="page" href="listItem">商品リスト</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="orderList">注文リスト</a>
        </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <c:out value="${adminName}" />
              <span class="caret"></span>
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="adminLogout">ログアウト</a>
            </div>
          </li>
        </ul>
        </div>
        </div>
    
  </nav>
</header>
