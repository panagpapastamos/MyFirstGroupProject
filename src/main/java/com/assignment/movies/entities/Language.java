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
@Table(name = "language")
public class Language implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long language_id;
    
    @Column(name = "language_name")
    private String languageName;
    
    @ManyToMany(mappedBy = "languages")
    private List<Movie> movies = new ArrayList<>();

    public Language() {
    }

    public Language(long language_id, String languageName) {
        this.language_id = language_id;
        this.languageName = languageName;
    }

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Language{language_id=").append(language_id);
        sb.append(", languageName=").append(languageName);
        sb.append(", movies=").append(movies);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.language_id ^ (this.language_id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.languageName);
        hash = 59 * hash + Objects.hashCode(this.movies);
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
        final Language other = (Language) obj;
        if (this.language_id != other.language_id) {
            return false;
        }
        if (!Objects.equals(this.languageName, other.languageName)) {
            return false;
        }
        if (!Objects.equals(this.movies, other.movies)) {
            return false;
        }
        return true;
    }

    
    
}
