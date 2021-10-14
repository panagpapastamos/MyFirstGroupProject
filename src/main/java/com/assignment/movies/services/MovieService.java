package com.assignment.movies.services;

import com.assignment.movies.entities.Movie;
import com.assignment.movies.repositories.MovieRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
    
    @Autowired
    private MovieRepository repository;
    
    public List<Movie> getAllMovies(){
       return repository.findAll();
    }
    
    public Movie getById(Long id){
        return repository.getById(id);
    }
    
    
    public boolean findById(Long id){
        return (repository.findById(id).get().getMovieId() > 0);
    }
    
    //There the implementantions of the methods in the repository to get some filtered movie lists
    public List<Movie> listPerReleaseDate(int limit){
        return repository.listPerReleaseDate(limit);
    }
    
    public List<Movie> listPerImdbRating(int limit){
        return repository.listPerImdRating(limit);
    }
    
    
    public List<Movie> listPerSellPrice(int limit){
        return repository.listPerSellPrice(limit);
    }
    

}
