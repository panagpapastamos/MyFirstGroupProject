package com.assignment.movies.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genreId;
    
    @Column(name = "genre_name")
    private String genreName;
    
    @ManyToMany(mappedBy = "genres")
    private List <Movie> movies = new ArrayList <>();

    public Genre() {
    }

    public Genre(long genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public List <Movie> getMovies() {
        return movies;
    }

    public void setMovies(List <Movie> movies) {
        this.movies = movies;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Genre{genreId=").append(genreId);
        sb.append(", genreName=").append(genreName);
        sb.append(", movies=").append(movies);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.genreId ^ (this.genreId >>> 32));
        hash = 23 * hash + Objects.hashCode(this.genreName);
        hash = 23 * hash + Objects.hashCode(this.movies);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Genre other = (Genre) obj;
        if (this.genreId != other.genreId) {
            return false;
        }
        if (!Objects.equals(this.genreName, other.genreName)) {
            return false;
        }
        if (!Objects.equals(this.movies, other.movies)) {
            return false;
        }
        return true;
    }
    
    

}
