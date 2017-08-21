<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html>
<head>
<title>Register - Powered by Steve Ou</title>
<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
<style>
  body{
    font-family: "Microsoft Yahei";
  }
</style>
</head>
<body>
<div class="jumbotron">
  <div class="container">
    <h3>Welcome ...</h3>
    <p>Lite Customer Relationship Manager System</p>
  </div>
</div>
<div class="container">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		${requestScope.hints }
		<form class="form-horizontal" method="post" action="register.action">
			<div class="form-group">
				<label for="username">Account</label>
				<span style="color:red"><s:if test="hasFieldErrors()"><s:property  value="fieldErrors['username'][0]"/></s:if></span>
				<div>
					<input id="username" name="username" type="text" class="form-control" value="${param.username }">
				</div>
			</div>
      		<div class="form-group">
				<label for="password">Password</label>
				<span style="color:red"><s:if test="hasFieldErrors()"><s:property  value="fieldErrors['password'][0]"/></s:if></span>
				<div>
					<input id="password" name="password" type="password" class="form-control" value="${param.password }">
				</div>
			</div>
      		<div class="form-group">
				<label for="password">Email</label>
				<span style="color:red"><s:if test="hasFieldErrors()"><s:property  value="fieldErrors['email'][0]"/></s:if></span>
				<div>
					<input id="email" name="email" type="email" class="form-control" value="${param.email }">
				</div>
			</div>
			<div class="form-group">
				<label for="password">Address</label>
				<span style="color:red"><s:if test="hasFieldErrors()"><s:property  value="fieldErrors['address'][0]"/></s:if></span>
				<div>
					<input id="address" name="address" type="text" class="form-control" value="${param.address }">
				</div>
			</div>
			<div class="form-group">
				<label for="password">Birthday (Format yyyy-mm-dd) </label>
				<span style="color:red"><s:if test="hasFieldErrors()"><s:property  value="fieldErrors['birthday'][0]"/></s:if></span>
				<div>
					<input id="birthday" name="birthday" type="text" class="form-control" value="${param.birthday }">
				</div>
			</div>
       <p class="form-group">Already have an account? <a href="index.jsp">Go back to login.</a></p>
      <button class="btn btn-success btn-block" type="submit">Register</button>
		</form>
	</div>
	<div class="col-md-4"></div>
</div>
</body>
</html>
 