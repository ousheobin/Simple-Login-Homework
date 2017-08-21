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
			<tr><td>Name</td><td>${sessionScope.userInfo.username }</td></tr>
			<tr><td>Address</td><td>${sessionScope.userInfo.address }</td></tr>
			<tr><td>Email</td><td>${sessionScope.userInfo.email }</td></tr>
			<tr><td>Birthday</td><td><fmt:formatDate value="${sessionScope.userInfo.birthday }" pattern="yyyy-MM-dd"/></td></tr>
		</table>
		<a href="${pageContext.request.contextPath }/logout.action" class="btn btn-primary btn-block">Logout</a>
	</div>
	<div class="col-md-2"></div>
</div>
</body> 
</html>
 