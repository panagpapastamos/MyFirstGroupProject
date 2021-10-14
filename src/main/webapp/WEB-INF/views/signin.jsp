<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="/css/signinStyle.css">
        <title>Sign In/Up</title>
        <script>
            $(document).ready(function () {
                $("#username").focusout(function () {
                    var username = $("#username").val();
                    $.ajax({
                        url: "checkusername/" + username,
                        success: function (result) {
                            $("#resultU").html(result);
                        }
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $("#email").focusout(function () {
                    var email = $("#email").val();
                    $.ajax({
                        url: "checkemail/" + email,
                        success: function (result) {
                            $("#resultE").html(result);
                        }
                    });
                });
            });
        </script>
    </head>
    <body style="background-image: url('/img/posters.jpg');">

        <div class="container" id="container">
			<div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p><strong>Did you miss your favorite movie site?</strong>
                            <br><br>
                           Please login with your personal info.</p>
                        
                        <button class="ghost" id="signIn" style="border: 3px solid yellowgreen; border-radius: 15px;">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Welcome!</h1>
                        <p>Click below to register <br>
                            by filling in your information.</p>
                        <button class="ghost" id="signUp" style="border: 3px solid yellowgreen; border-radius: 15px;">Sign Up</button>
                    </div>
                </div>
            </div>
            <div class="form-container sign-up-container">
                <form:form action="/users/register" method="POST" modelAttribute="user">
                    <h3>Or..</h3>
                    <h2><u>Create New Account</u></h2>



                    <form:input type="text" placeholder="Username" path="username" id="username" /> 
                    <form:input type="email" placeholder="Email" path="email" id="email" />
                    <form:input type="password" placeholder="Password" path="password"/>    
                    <div id="resultU">${message}</div>
                    <div id="resultE">${message}</div>
                    <br>
                    <button type="submit" style="border: 3px solid crimson; border-radius: 15px;">Sign Up</a></button>
                </form:form>
            </div>
            <div class="form-container sign-in-container">
                <form method="POST" action="/users/signIn">
                    <h1><u>Sign in</u></h1>
                    <br>

                    <input type="text" placeholder="Username" name="username" />
                    <input type="password" placeholder="Password" name="password"/>
                    <br>

                    <button type="submit" style="border: 3px solid crimson; border-radius: 15px;">Sign In</button>
                </form>
            </div>
            
        </div>


    </body>
    <script src="/js/signinScript.js"></script>
</html>

