package com.assignment.movies.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "movie")
public class Movie implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long  movieId;
    
    @OneToOne
    @JoinColumn(name = "director_id")
    private Director director;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "movie_genres",
            joinColumns = {
                @JoinColumn(name = "movie_id")},
                inverseJoinColumns ={@JoinColumn(name = "genre_id")})
    private List <Genre> genres = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "movie_company",
            joinColumns = {
                @JoinColumn(name = "movie_id")},
                inverseJoinColumns ={@JoinColumn(name = "company_id")})
    private List <DistributionCompany> companies = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "movie_langs",
            joinColumns = {
                @JoinColumn(name = "movie_id")},
                inverseJoinColumns ={@JoinColumn(name = "language_id")})
    private List <Language> languages = new ArrayList<>();
    
    @OneToMany(mappedBy = "movieM", cascade = CascadeType.ALL)
    private List <MovieCast> cast;
    
    private String title;
    
    @Column(name = "box_office")
    private String boxOffice;
    
    private String budget;
    
    @Column(name = "logo_img")
    private String logo;
    
    private String summary;
    
    @Column(name = "release_date")
    private LocalDate releaseDate;

    private int duration;
    
    @Column(name = "sell_price")
    private double sellPrice;
    
    @Column(name = "trailer_url")
    private String trailerUrl;
    
    @Column(name="imdb_rating")
    private double imdbRating;

    public Movie() {
    }

    public Movie(Long movieId, Director director, List<MovieCast> cast, String title, String boxOffice, String budget, String logo, String summary, LocalDate releaseDate, int duration, double sellPrice, String trailerUrl, double imdbRating) {
        this.movieId = movieId;
        this.director = director;
        this.cast = cast;
        this.title = title;
        this.boxOffice = boxOffice;
        this.budget = budget;
        this.logo = logo;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.sellPrice = sellPrice;
        this.trailerUrl = trailerUrl;
        this.imdbRating = imdbRating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List <Genre> getGenres() {
        return genres;
    }

    public void setGenres(List <Genre> genres) {
        this.genres = genres;
    }

    public List <DistributionCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List <DistributionCompany> companies) {
        this.companies = companies;
    }

    public List <Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List <Language> languages) {
        this.languages = languages;
    }

    public List <MovieCast> getCast() {
        return cast;
    }

    public void setCast(List <MovieCast> cast) {
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie{movieId=").append(movieId);
        sb.append(", director=").append(director);
        sb.append(", genres=").append(genres);
        sb.append(", companies=").append(companies);
        sb.append(", languages=").append(languages);
        sb.append(", cast=").append(cast);
        sb.append(", title=").append(title);
        sb.append(", boxOffice=").append(boxOffice);
        sb.append(", budget=").append(budget);
        sb.append(", logo=").append(logo);
        sb.append(", summary=").append(summary);
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", duration=").append(duration);
        sb.append(", sellPrice=").append(sellPrice);
        sb.append(", trailerUrl=").append(trailerUrl);
        sb.append(", imdbRating=").append(imdbRating);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.movieId);
        hash = 23 * hash + Objects.hashCode(this.director);
        hash = 23 * hash + Objects.hashCode(this.genres);
        hash = 23 * hash + Objects.hashCode(this.companies);
        hash = 23 * hash + Objects.hashCode(this.languages);
        hash = 23 * hash + Objects.hashCode(this.cast);
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + Objects.hashCode(this.boxOffice);
        hash = 23 * hash + Objects.hashCode(this.budget);
        hash = 23 * hash + Objects.hashCode(this.logo);
        hash = 23 * hash + Objects.hashCode(this.summary);
        hash = 23 * hash + Objects.hashCode(this.releaseDate);
        hash = 23 * hash + this.duration;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.sellPrice) ^ (Double.doubleToLongBits(this.sellPrice) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.trailerUrl);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.imdbRating) ^ (Double.doubleToLongBits(this.imdbRating) >>> 32));
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
        final Movie other = (Movie) obj;
        if (this.duration != other.duration) {
            return false;
        }
        if (Double.doubleToLongBits(this.sellPrice) != Double.doubleToLongBits(other.sellPrice)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imdbRating) != Double.doubleToLongBits(other.imdbRating)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.boxOffice, other.boxOffice)) {
            return false;
        }
        if (!Objects.equals(this.budget, other.budget)) {
            return false;
        }
        if (!Objects.equals(this.logo, other.logo)) {
            return false;
        }
        if (!Objects.equals(this.summary, other.summary)) {
            return false;
        }
        if (!Objects.equals(this.trailerUrl, other.trailerUrl)) {
            return false;
        }
        if (!Objects.equals(this.movieId, other.movieId)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.genres, other.genres)) {
            return false;
        }
        if (!Objects.equals(this.companies, other.companies)) {
            return false;
        }
        if (!Objects.equals(this.languages, other.languages)) {
            return false;
        }
        if (!Objects.equals(this.cast, other.cast)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    
   
   
}
