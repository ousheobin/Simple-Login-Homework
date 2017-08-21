<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html>
<head>
<title>Login - Powered by Steve Ou</title>
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
		<form class="form-horizontal" method="post" action="login.action">
			<div class="form-group">
				<label for="username">Account</label>
				<div>
					<input id="username" name="username" type="text" class="form-control">
				</div>
			</div>
      <div class="form-group">
				<label for="password">Password</label>
				<div>
					<input id="password" name="password" type="password" class="form-control">
				</div>
			</div>
			<div class="form-group">
        <label>Account Type</label>
        <div>
          <span class="radio-inline">
            <input type="radio" name="type" id="account1" value="user" checked="true"> Customer
          </span>
          <span class="radio-inline">
            <input type="radio" name="type" id="account2" value="admin"> Administrator
          </span>
        </div>
	  </div>
	  <p class="form-group">Haven't got an account?<br><a href="register.jsp">Click here to register an new account.</a></p>
      <button class="btn btn-success btn-block" type="submit">Login</button>
		</form>
	</div>
	<div class="col-md-4"></div>
</div>
</body>
</html>
 