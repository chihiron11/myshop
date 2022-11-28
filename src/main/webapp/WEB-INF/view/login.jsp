<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
<title>MyShop</title>
</head>
<c:import url="parts/headertop2.jsp" />
<body id="loginPage">
<div class="wrapper">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-4">
				<div class="card login-panel">
					<div class="card-header">ログイン</div>
					<div class="card-body">
						<!-- ↓↓エラーメッセージがある場合↓↓ -->

						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<p>ログインIDかパスワードが正しくありません</p>
							</div>
						</c:if>

						<!-- ↑↑エラーメッセージがある場合↑↑ -->


						<form action="" method="post">
							<div class="mb-3">
								<c:if test="${not empty loginIdError }">
									<div class="error-message">
										<p>
											<c:out value="※${loginIdError}" />
										</p>
									</div>
								</c:if>

								<input type="text" name="loginId" placeholder="ログインID"
									class="form-control" value="<c:out value="${loginId}" />">
							</div>
							<div class="mb-3">
								<c:if test="${not empty loginPassError }">
									<div class="error-message">
										<p>
											<c:out value="※${loginPassError}" />
										</p>
									</div>
								</c:if>
								<input type="password" name="loginPass" placeholder="パスワード"
									class="form-control" value="<c:out value="${loginPass}" />">
							</div>
							<div class="mb-3">
								<input type="submit" class="btn btn-primary btn-block"
									value="ログイン">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	<div class="fixed-bottom">
<div class="container-fluid bg-light text-dark text-center pt-4 pb-2">
    <p><small> Myshop</small></p>    
   </div>
   </div>
   </footer> 
   </div>
	<script src="js/jquery-3.6.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
