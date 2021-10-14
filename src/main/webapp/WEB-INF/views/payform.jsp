<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.0/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="/css/style.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link 
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Rubik&display=swap"
            rel="stylesheet"
            />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&family=Sen:wght@400;700;800&display=swap"
            rel="stylesheet"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
            />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Payment Form</title>
    </head>
    <body style="background-color: #151515;">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark " >
                <div class="container" style="margin-right: 55px;">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/home" style="color: #25bd0a;">katiTainies</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav ms-auto text-center">
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/home">Home</a>
                            </li>                            
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/users/signIn">Sign in/Up</a>
                            </li>                            
                        </ul>
                    </div>
                </div>
                <hr>
            </nav>
            <div style="display: none" id="home"></div>
            <div  class="movie-list-container" style="margin-right: 55px;">
                <br>
                <div id="movies" class="container mb-3 mt-3">
                    <h1 class="movie-list-title ms-auto text-center" style="font-size: 33px;" >PAYMENT</h1>
                    <div class="card-dark" >
                        <div class="card-body">
                            <form:form action="${pageContext.request.contextPath}/payment/form" method="POST" modelAttribute="order">

                                <div class="form-group row">
                                    <label for="price" class="col-sm-2 col-form-label">Price</label>
                                    <div class="col-sm-7">
                                        <form:input type="text" class="form-control" name="Price"
                                                    placeholder="Enter Price" path="price" value="${sellPrice}"/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="currency" class="col-sm-2 col-form-label" for="specificSizeSelect">Currency</label>
                                    <div class="col-sm-7"><form:select class="form-select" id="specificSizeSelect" path="currency">
                                            <form:option value="EUR" label="EUR"/>
                                            <form:option value="USD" label="USD"/>
                                            <form:option value="JPY" label="JPY"/>
                                        </form:select></div>
                                </div>

                                <div class="form-group row">
                                    <label for="method" class="col-sm-2 col-form-label" for="specificSizeSelect">Method</label>
                                    <div class="col-sm-7"><form:select class="form-select" id="specificSizeSelect" path="method">
                                            <form:option value="PAYPAL" label="PAYPAL"/>
                                        </form:select></div>
                                </div>

                                <div class="form-group row">
                                    <label for="intent" class="col-sm-2 col-form-label" for="specificSizeSelect">Intent</label>
                                    <div class="col-sm-7"><form:select class="form-select" id="specificSizeSelect" path="intent">
                                            <form:option value="SALE" label="SALE"/>
                                            <form:option value="ORDER" label="ORDER"/>
                                        </form:select></div>
                                </div>

                                <div class="form-group row">
                                    <label for="description" class="col-sm-2 col-form-label">Description</label>
                                    <div class="col-sm-7">
                                        <form:input type="text" class="form-control" name="Description"
                                                    placeholder="Enter Description" path="description"/>
                                    </div>
                                </div>
                                <button class="card-link text-center btn btn-outline-success"  type="submit" class="btn btn-primary">Pay</button>
                            </form:form>
                        </div>
                    </div>   
                </div>
            </div>
        </div>
        <section>
            <footer class="text-center text-white footer-dark" >
                <div class="container p-4 pb-0">
                    <section class="">
                        <p class="d-flex justify-content-center align-items-center">
                            <span class="me-3">Register for free</span>
                            <a href="<%=request.getContextPath()%>/users/signIn"><button type="button" class="btn btn-outline-light btn-rounded">
                                    Sign up!
                                </button></a>
                        </p>
                    </section>
                </div>
                <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                    © 2021 Copyright:
                    <p class="topleft"><sec:authentication property="principal.username" /></p> 
                    <a class="text-white" href="#">CB 13</a>
                </div>
            </footer>
        </section>               
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.0/js/dataTables.bootstrap4.min.js"></script>
    </body>
</html>
