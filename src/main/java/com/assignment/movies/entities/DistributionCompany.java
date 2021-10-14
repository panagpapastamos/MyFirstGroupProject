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
@Table(name = "distrib_comp")
public class DistributionCompany implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;
    
    @Column(name = "company_name")
    private String companyName;
    
    @ManyToMany(mappedBy = "companies")
    private List <Movie> movies = new ArrayList<>();

    public DistributionCompany() {
    }

    public DistributionCompany(Long companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List <Movie> getMovies() {
        return movies;
    }

    public void setMovies(List <Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DistributionCompany{companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", movies=").append(movies);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.companyId);
        hash = 53 * hash + Objects.hashCode(this.companyName);
        hash = 53 * hash + Objects.hashCode(this.movies);
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
        final DistributionCompany other = (DistributionCompany) obj;
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        if (!Objects.equals(this.companyId, other.companyId)) {
            return false;
        }
        if (!Objects.equals(this.movies, other.movies)) {
            return false;
        }
        return true;
    }

    
}
