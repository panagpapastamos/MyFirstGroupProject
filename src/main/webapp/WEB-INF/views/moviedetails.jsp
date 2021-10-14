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
        <link rel="stylesheet" href="/css/movieDetails.css" />
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
        <title>Movie Details</title>
    </head>
    <body style="background-color: #151515;">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark " >
                <div class="container-fluid" style="margin-right: 55px;">
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
                                <a class="nav-link" href="<%=request.getContextPath()%>/movies/allmovies">Movies</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/users/signIn">Sign in/Up</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <hr>
            </nav>
            <div  class="movie-list-container" style="margin-right: 55px;">
                <br>
                <div style="display:flex;flex-direction: row">
                    <iframe style="width:80%"  height="600px" src="<c:url value="${movieDetails.trailerUrl}"/>">
                    </iframe>
                    <span style="margin-left: 4px;margin-right: 4px;"></span>
                    <div class="card" style="width:20%;background: #483d3c14;">
                        <img class="card-img-top" src="${movieDetails.logo}" alt="${movieDetails.title}">
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${movieDetails.title}"></c:out></h5>
                            <p class="card-text">Price: <c:out value="${movieDetails.sellPrice}"></c:out> $</p>
                            </div>
                            <ul style="font-size:12px" class="list-group list-group-flush">
                                <li style="color:#ffffff;background: #483d3c14" class="list-group-item"><h5>Cast</h5><c:forEach items="${movieDetails.cast}" var = "cast">
                                    ${cast.actor.actorFname} ${cast.actor.actorLname} - ${cast.characterName} <br>
                                </c:forEach></li>
                        </ul>
                        <div class="card-body">
                            <a  href="<%=request.getContextPath()%>/payment/${movieDetails.sellPrice}"><button class="card-link btn btn-outline-success">Buy</button></a>  
                        </div>
                    </div>  
                </div>
                <br>
                <div style="width:81%;margin-top: -5%;">
                    <h3>Summary</h3>
                    <p  class="card-text"><c:out value="${movieDetails.summary}"></c:out></p>
                    </div>
                </div>
            </div>
            <br>
            <div class="container mb-5 mt-3">
                <table class="table card-text" style="width: 100%;border:none" >
                    <thead style="color:white;">
                        <tr>
                            <th>Director</th>
                            <th>Genre</th>
                            <th>Distribution Company</th>
                            <th>Languages</th>
                            <th>Box Office</th>
                            <th>Budget</th>
                            <th>Date</th>
                            <th>Duration</th>                               
                        </tr>
                    </thead>
                    <tbody  style="color:white;">
                        <tr>                               
                            <td><c:out value="${movieDetails.director.directorFname}${' '}${movieDetails.director.directorLname}"></c:out></td>
                        <td><c:forEach items="${movieDetails.genres}" var = "genre">
                                ${genre.genreName}
                            </c:forEach></td>
                        <td><c:forEach items="${movieDetails.companies}" var = "company">
                                ${company.companyName}
                            </c:forEach></td>
                        <td><c:forEach items="${movieDetails.languages}" var = "language">
                                ${language.languageName}
                            </c:forEach></td>
                        <td><c:out value="${movieDetails.boxOffice}"></c:out></td>
                        <td><c:out value="${movieDetails.budget}"></c:out></td>
                        <td><c:out value="${movieDetails.releaseDate}"></c:out></td>
                        <td><c:out value="${movieDetails.duration}"></c:out> min</td>                                
                    </tr>
                </tbody>
            </table>
        </div>
        <section>
            <footer class="text-center text-white footer-dark" >
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
        <script>
            $('.mydatatable').DataTable(
                    {
                        searching: true,
                        ordering: false,
                        lengthMenu: [["All"]]
                    });
        </script>
    </body>
</html>