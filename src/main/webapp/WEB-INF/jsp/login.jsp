<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- CSS -->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=PT+Sans:400,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/modules/login/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/modules/login/supersized.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/modules/login/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->

</head>
<body>
	<div class="page-container">
		<h1>Login</h1>
		<form id="loginForm" action="" method="post">
			<input type="text" name="username" class="username"
				placeholder="Username"> <input type="password"
				name="password" class="password" placeholder="Password">
			<button id="btn_login" type="button">Sign me in</button>
			<div class="error" style="top: 27px; display: none;"></div>
		</form>
	</div>
	<ul id="supersized" class="quality" style="visibility: visible;">
		<li class="slide-0 activeslide"
			style="visibility: visible; opacity: 1;"><a target="_blank"><img
				src="${pageContext.request.contextPath}/imgs/login_back.jpg"
				style="width: auto; left: 0px; top: -171px; height: 884.1px;"></a>
		</li>
	</ul>
</body>
<%@include file="/modules/jquery/jquery_js.jsp"%>
<%@include file="/modules/jquery/jquery_validate_js.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/login/login.js"></script>
</html>