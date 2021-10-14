package com.assignment.movies.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie_cast")
public class MovieCast implements Serializable{
    
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movieM;
    @Column(name ="character_name")
    private String characterName;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public MovieCast() {
    }

    public MovieCast(Movie movie, String characterName, Actor actor) {
        this.movieM = movie;
        this.characterName = characterName;
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movieM;
    }

    public void setMovie(Movie movie) {
        this.movieM = movie;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieCast{movie=").append(movieM);
        sb.append(", characterName=").append(characterName);
        sb.append(", actor=").append(actor);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.movieM);
        hash = 11 * hash + Objects.hashCode(this.characterName);
        hash = 11 * hash + Objects.hashCode(this.actor);
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
        final MovieCast other = (MovieCast) obj;
        if (!Objects.equals(this.characterName, other.characterName)) {
            return false;
        }
        if (!Objects.equals(this.movieM, other.movieM)) {
            return false;
        }
        if (!Objects.equals(this.actor, other.actor)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
    

