<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Homepage</title>

	<!-- Bootstrap Core CSS -->
	<link href="/SpringLoginForm/resources/css/bootstrap.css" rel="stylesheet">
	
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		
		
	</div>
	<!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

	<div class="row">


	</div>
	<!-- /.container -->

	<div class="container">

		<hr>
		
		<br/><br/>
		[Homepage content]
		
		<br/><br/>
		<div class="form-group">
		    <div class="col-md-12 control">
		        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
		            <a href="<c:url value="/signin" />">
		                Login Here
		            </a>
		        </div>
		    </div>
		</div>
                     
<!-- 		using logout with CSRF you must perform a POST. See http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf-logout -->
<%-- 		<a href="<c:url value="/logout" var="logoutUrl" />"> --%>
<!-- 			Logout -->
<!-- 		</a> -->
		<br/><br/>
		<div class="form-group">
		    <div class="col-md-12 control">
		        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
					<form:form action="${pageContext.request.contextPath}/logout" method="POST">
					    <input type="submit" value="Logout" />
					</form:form>
		        </div>
		    </div>
		</div>
		

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
				
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->
	
	
	<!-- jQuery -->
<!--     <script src="/SpringLoginForm/resources/js/jquery.js"></script> -->
	<!-- Bootstrap Core JavaScript -->
<!-- 	<script src="/SpringLoginForm/resources/js/bootstrap.js"></script> -->

</body>

</html>

