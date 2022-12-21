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
 <div class="title">
  <h1>MY PAGE</h1>
  <div id="mypage">
  <div class="register">
  <p>会員登録情報</p>
  <table>
  <tr>
  <td>名前</td><td><c:out value="${name }" /></td>
  <tr>
  <td>住所</td><td><c:out value="${address}" /></td>
  </tr>
  <tr>
  <td>TEL</td><td><c:out value="${tel}" /></td>
  </tr>
  <tr>
  <td>ログインID</td><td><c:out value="${loginId}" /></td>
  </tr>
 
  </table>
  </div>
  <div class="orderhistory">
  
  <p>注文履歴</p>
 
   <c:forEach items="${userbyorderList}" var="userbyorderList">
  
  <table>
  <tr>
  <td rowspan="5"><img class="itemimage" src="uploads/<c:out value="${userbyorderList.itemImage}" />" ></td>
 
  <tr>
  <td>注文番号</td><td><c:out value="${userbyorderList.id}" /></td>
  </tr>
  <tr>
  <td>注文日</td><td><c:out value="${userbyorderList.ordered}" /></td>
  </tr>
  <tr>
  <td>商品名</td><td><c:out value="${userbyorderList.itemName}" /></td>
  </tr>
  <tr>
  <td>金額</td><td><c:out value="${userbyorderList.itemPrice}" />円</td>
  </tr>
  
  </table>
  </c:forEach>
  </div>
  </div>
  </div>
<footer>
		<div class="container-fluid text-dark text-center pt-4 pb-2">
			<p>
				<small> Myshop</small>
			</p>
		</div>
	</footer>
</body>
</html>