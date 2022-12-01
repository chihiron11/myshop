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
<title>商品管理</title>
</head>
<body>
	<c:import url="parts/header.jsp" />
	<div class="container">
		<h1>商品編集</h1>
		<div class="row justify-content-center">
			<div class="col-6">
				<form action="" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="formName">商品名</label>
						<c:if test="${not empty nameError }">
							<div class="error-message">
								<p>
									<c:out value="※${nameError }" />
								</p>
							</div>
						</c:if>


						<input type="text" name="name" value="<c:out value="${name}" />"
							id="formName" class="form-control">
					</div>
					<div class="mb-3">
						<label for="formPrice">金額</label>
						<c:if test="${not empty priceError }">
							<div class="error-message">
								<p>
									<c:out value="※${priceError }" />
								</p>
							</div>
						</c:if>
						<input type="text" name="price" value="<c:out value="${price}" />"
							id="formPrice" class="form-control">
					</div>

					<!--  画像アップロード記述-->

					<div class="mb-3">

						<label for="inputFile">画像アップロード</label> 
						<label for="formFile"class="form-label"></label> 
						<input class="form-control"type="file" id="formFile" name="upfile">
						<img src="uploads/<c:out value="${image}" />" height="180px">
						<p><c:out value="${image}" /></p>
					</div>

					
					<div class="mb-3">
						<label for="formNote">商品説明</label>
						<textarea name="note" id="formNote" class="form-control"><c:out value="${note}" /></textarea>
					</div>
					<div class="mb-3">
						<input type="submit" class="btn btn-primary" value="更新"> <a
							href="listItem" class="btn btn-light">キャンセル</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.6.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>