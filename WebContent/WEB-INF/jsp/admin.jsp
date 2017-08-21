<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <!DOCTYPE html>
<html>
<head>
<title>Your information - Powered by Steve Ou</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/res/css/bootstrap.min.css">
<style>
  body{
    font-family: "Microsoft Yahei";
  }
</style>
</head>
<body>
<div class="jumbotron">
  <div class="container">
    <h3>Customer Information</h3>
    <p>Lite Customer Relationship Manager System</p>
  </div>
</div>
<div class="container">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	<h4>Your Information</h4>
		<table class="table">
			<tr><th>Name</th><th>Address</th><th>Email</th><th>Birthday</th></tr>
			<c:forEach items="${requestScope.customers }" var="items">
				<tr><td>${items.username }</td><td>${items.address }</td><td>${items.email }</td><td> <fmt:formatDate value="${items.birthday }" pattern="yyyy-MM-dd"/></td></tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/logout.action" class="btn btn-primary btn-block">Logout</a>
	</div>
	<div class="col-md-2"></div>
</div>
</body> 
</html>
 