<%-- 
    Document   : register
    Created on : Mar 9, 2024, 11:10:41 PM
    Author     : phamt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="Kodinger">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>My Login Page &mdash; Bootstrap 4 Login Page Snippet</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/my-login.css">
    </head>
    <body class="my-login-page">
        <section class="h-100">
            <div class="container h-100">
                <div class="row justify-content-md-center h-100">
                    <div class="card-wrapper">
                        <!--                        <div class="brand">
                                                    <img src="img/logo.jpg" alt="bootstrap 4 login page">
                                                </div>-->
                        <div class="card fat">
                            <div class="card-body">
                                <h4 class="card-title">Register</h4>
                                
                                <form action="signup" method="POST" class="my-login-validation" novalidate="">

                                    <div class="form-group">
                                        <label for="user">User</label>
                                        <input name="user" id="user" type="text" class="form-control" name="user"  required>
                                        <div class="invalid-feedback">
                                            User is required
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input name="pass" id="password" type="password" class="form-control" name="password" required data-eye>
                                        <div class="invalid-feedback">
                                            Password is required
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirmPassword">Confirm Password</label>
                                        <input name="rePass" id="confirmPassword" type="password" class="form-control" name="confirmPassword" required>
                                        <div class="invalid-feedback">
                                            Please confirm your password
                                        </div>
                                    </div>


                                    <div class="form-group m-0">
                                        <button type="submit" class="btn btn-primary btn-block">
                                            Register
                                        </button>
                                    </div>
                                    <div class="mt-4 text-center">
                                        Already have an account? <a href="login.jsp">Login</a>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/my-login.js"></script>
    </body>
</html>