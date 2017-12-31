<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.03.2015
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
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

    <title>Signin</title>
    
    <!-- Bootstrap Core CSS -->
    <link href="/SpringLoginForm/resources/css/bootstrap.css" rel="stylesheet">
    
</head>

<body>

<!-- Page Content -->
<div class="container" style="margin-top:75px">

    <div class="container">
        <div id="loginbox" style="margin-top:50px;" 
        	class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <div class="panel-title">Sign In</div>
                </div>

                <div style="padding-top:30px" class="panel-body" >

                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                    <form action="<c:url value='login'/>" method="POST" id="loginform" class="form-horizontal" role="form">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input id="login-username" type="text" class="form-control" name="username"  placeholder="email">
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                        </div>
						
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 

                        <div style="margin-top:10px" class="form-group">
                            <!-- Button -->

                            <div class="col-sm-12 controls">
                                <input type="submit" value="Login" id="btn-login" class="btn btn-success">
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                    Don't have an account!
                                    <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                        Sign Up Here
                                    </a>
                                </div>
                            </div>
                        </div>


                    </form>
                </div>
            </div>
        </div>

        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Sign Up</div>
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                </div>
                <div class="panel-body" >
                    <form:form method="post" action="/signup"  id="signupform" class="form-horizontal" commandName="newUser" role="form">
                    
                        <div id="signupalert" style="display:none" class="alert alert-danger">
                            <p>Error:</p>
                            <span></span>
                        </div>

                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input path="email" class="form-control" name="email" placeholder="Email Address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="firstname" class="col-md-3 control-label">First Name</label>
                            <div class="col-md-9">
                                <form:input path="firstName" type="text" class="form-control" name="firstname" placeholder="First Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-md-3 control-label">Last Name</label>
                            <div class="col-md-9">
                                <form:input type="text" path="lastName" class="form-control" name="lastname" placeholder="Last Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Password</label>
                            <div class="col-md-9">
                                <form:input path="password" type="password" class="form-control" name="passwd" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Confirm Password</label>
                            <div class="col-md-9">
                                <form:input path="confirmPassword" type="password" class="form-control" name="passwd" placeholder="Password"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                               <input id="btn-signup" type="submit" value="Register" class="btn btn-info">
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>

        </div>
    </div>

</div>

	<!-- jQuery -->
    <script src="/SpringLoginForm/resources/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/SpringLoginForm/resources/js/bootstrap.js"></script>

</body>

</html>
