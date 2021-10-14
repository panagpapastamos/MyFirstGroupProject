package com.assignment.movies.repositories;

import com.assignment.movies.entities.Movie;
import java.util.List;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Node.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository <Movie, Long>{
    
    //Some queries to get some lists filtered through a field
    @Query(value="SELECT * FROM movie ORDER BY RELEASE_DATE DESC LIMIT ?1",nativeQuery = true)
    List<Movie> listPerReleaseDate(int limit);
    
    @Query(value="SELECT * FROM movie ORDER BY IMDB_RATING DESC LIMIT ?1",nativeQuery = true)
    List<Movie> listPerImdRating(int limit);
    
    @Query(value="SELECT * FROM movie ORDER BY SELL_PRICE DESC LIMIT ?1",nativeQuery = true)
    List<Movie> listPerSellPrice(int limit);
    
    

}
