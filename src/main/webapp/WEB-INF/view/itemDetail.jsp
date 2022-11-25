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
<c:import url="parts/headertop.jsp" />
    
<main>
 <form action ="" method="post">
  <div id="item" class="wrapper">
 
        <div class="item-image">
         <img src="uploads/<c:out value="${image}" />" height="500px">
        </div>
      <div class="item-info">
          <div class="item-name">
         <p><c:out value="${name }" /></p>
         <p><c:out value="${price}" />円</p>
        <p><c:out value="${note}" /></p>
      <p><input type="submit" class="btn btn-primary" value="注文する"></p>
    </div>
    
  </div>
   </div>
  </form>
 
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</main>
<script>

</script>
</body>
</html>