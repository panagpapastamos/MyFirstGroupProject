package com.assignment.movies.controllers;

import com.assignment.movies.entities.Movie;
import com.assignment.movies.services.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("movies")
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    //This piece of code simply feeds the view all the movies to present them to the registered user
     @GetMapping("/allmovies")
    public String getMovies(Model model) {
         List<Movie> movies = service.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }
    
    //This piece code gives the view which presents a specific movie the one the user will press on based on its Id
    @GetMapping(value = "/movieDetails/{movieId}")
    public String getMovieDetails(@PathVariable("movieId") Long movieId, Model model) {
        Movie movieDetails = service.getById(movieId);
        model.addAttribute("movieDetails", movieDetails);
        return "moviedetails";
    }
    
    //This is the view where the customer will watch the movie they paid for.
    //We use the idea to put movies to the tomcat server but we couldn't put 20 movies because the sevrer would have issues 
    //in its performance so we put one movie to a specific folder in the server (../webapps/Movie/) and we use the front to 
    //take it from the server directly. The logic works but we couldn't apply for 20 movies because it would have been difficult
    //for the server to function
    @GetMapping("/watch")
    public String watchMovie(){
        return "watchmovie";
    }

}
