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
	<div class="container">
		
		<div class="row justify-content-center">
			<div class="col-4">
			<h1>新規会員登録</h1>
				<form action="" method="post">
					<div class="mb-3">
						<label for="formName">名前</label>
						<c:if test ="${not empty nameError }">
          				<div class="error-message">
       				   <p><c:out value="※${nameError }" /></p>
         			 </div>
        			 </c:if>
						<input type="text" name="name" value="<c:out value="${name}" />" class="form-control">
					</div>
					<div class="mb-3">
						<label for="formAddress">メールアドレス</label>
							<c:if test ="${not empty addressError }">
          				<div class="error-message">
       				   <p><c:out value="※${addressError }" /></p>
         			 </div>
        			 </c:if>
						<input type="text" name="address" value="<c:out value="${address}" />" class="form-control">
					</div>

					

					<div class="mb-3">
						<label for="formTel">TEL</label>
							<c:if test ="${not empty telError }">
          				<div class="error-message">
       				   <p><c:out value="※${telError }" /></p>
         			 </div>
        			 </c:if>
						<input type="text" name="tel" value="<c:out value="${tel}" />" class="form-control">
					</div>
					<div class="mb-3">
						<label for="formLoginId">ログインID</label>
							<c:if test ="${not empty loginIdError }">
          				<div class="error-message">
       				   <p><c:out value="※${loginIdError }" /></p>
         			 </div>
        			 </c:if>
						<input type="text" name="loginId" value="<c:out value="${loginId}" />" class="form-control">
					</div>
					<div class="mb-3">
						<label for="formLoginPass">パスワード</label>
							<c:if test ="${not empty loginPassError }">
          				<div class="error-message">
       				   <p><c:out value="※${loginPassError }" /></p>
         			 </div>
        			 </c:if>
						<input type="text" name="loginPass"  class="form-control">
					</div>
					
					<div class="mb-3">
						<input type="submit" class="btn btn-primary" value="登録"> <a
							href="top" class="btn btn-light">キャンセル</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.6.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>