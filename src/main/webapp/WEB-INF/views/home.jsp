<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/css/all.css" />
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link 
            href="https://fonts.googleapis.com/css2?family=Lobster&family=Rubik&display=swap"
            rel="stylesheet"
            />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/styleN.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
            />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>katiTainies</title>
    </head>
    <body style="background-color: #151515;">
        <div class="container" >
            <nav class="navbar navbar-expand-lg navbar-dark ">
                <div class="container-fluid">
                    <a class="navbar-brand" href="<%=request.getContextPath()%>/home" style="color: #25bd0a;" >katiTainies</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                        <ul class="navbar-nav ms-auto text-center">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/home">Home</a>
                            </li>
                            <li class="nav-item">                            
                                <a class="nav-link" href="<%=request.getContextPath()%>/movies/allmovies">Movies</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#popular">Popular</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#price">Best Price</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/users/signIn">Sign in/Up</a>    
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="content-container"  style="margin-right: 55px;">
            <div
                class="featured-content"
                style="
                background: linear-gradient(to bottom, rgba(0, 0, 0, 0), #151515),
                url('img/f-1.jpg');border-radius: 18px;
                " 
                >
                <img class="featured-title" src="img/f-t-1.png" alt="" />
                <div class="summary2" style="color:#947f7f;">
                    <br>
                    <c:out value="${oneMovie2.summary}" />
                </div>
                <a class="nav-link" href="<%=request.getContextPath()%>/movies/allmovies"><button class="featured-button  btn btn-outline-secondary">MORE</button></a>  
            </div>                                        
            <br>
            <div class="movie-list-container">
                <br>                                           
                <h1 class="movie-list-title text-center" style="color:white;font-size: 30px;">NEW RELEASES</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach items="${moviesD}" var="movie">
                            <div class="movie-list-item">
                                <img class="movie-list-item-img" src="${movie.logo}" alt="${movie.title}" />
                                <a class="onemovie-details" href="<c:url value="/movies/movieDetails/${movie.movieId}" />" >details</a>
                                <span class="movie-list-item-title" style="color:white;">${movie.title}</span>
                            </div>
                        </c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
            <div id="popular" class="movie-list-container">
                <h1 class="movie-list-title text-center"  style="color:white;font-size: 30px;">POPULAR</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach items="${moviesR}" var="movie">
                            <div class="movie-list-item">
                                <img class="movie-list-item-img" src="${movie.logo}" alt="${movie.title}" />
                                <a class="onemovie-details" href="<c:url value="/movies/movieDetails/${movie.movieId}" />" >details</a>
                                <span class="movie-list-item-title" style="color:white;">${movie.title}</span>
                            </div>
                        </c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
                </div>
            </div>
            <div
                class="featured-content"
                style="
                background: linear-gradient(to bottom, rgba(0, 0, 0, 0), #151515),
                url('img/8.jpg');border-radius: 18px;
                "
                >
                <div class="oneMovie-title" style="color: white;font-size: 30px;">
                    <br>
                    <c:out value="${oneMovie.title}" />
                    <br>  
                </div>
                <div class="summary" style="color:#947f7f;">
                    <br>
                    <c:out value="${oneMovie.summary}" />
                </div>
                <br>
                <a class="nav-link" href="<%=request.getContextPath()%>/movies/allmovies"><button class="featured-button  btn btn-outline-secondary">MORE</button></a>  
            </div>
            <div id="price" class="movie-list-container">
                <br>
                <h1 class="movie-list-title text-center"  style="color:white;font-size: 30px;">BEST PRICE</h1>
                <div class="movie-list-wrapper">
                    <div class="movie-list">
                        <c:forEach items="${moviesP}" var="movie">
                            <div class="movie-list-item">
                                <img class="movie-list-item-img" src="${movie.logo}" alt="${movie.title}" />
                                <a class="onemovie-details" href="<c:url value="/movies/movieDetails/${movie.movieId}" />" >details</a>
                                <span class="movie-list-item-title" style="color:white;">${movie.title}</span>
                            </div>
                        </c:forEach>
                    </div>
                    <i class="fas fa-chevron-right arrow"></i>
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
        <script src="/js/app.js"></script>
    </body>
</html>

