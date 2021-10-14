package com.assignment.movies.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "director")
public class Director implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name  = "director_id")
    private Long directorId;

    @Column(name = "director_Fname")
    private String directorFname;
    
    @Column(name = "director_Lname")
    private String directorLname;

    public Director() {
    }

    public Director(Long directorId, String directorFname, String directorLname) {
        this.directorId = directorId;
        this.directorFname = directorFname;
        this.directorLname = directorLname;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorFname() {
        return directorFname;
    }

    public void setDirectorFname(String directorFname) {
        this.directorFname = directorFname;
    }

    public String getDirectorLname() {
        return directorLname;
    }

    public void setDirectorLname(String directorLname) {
        this.directorLname = directorLname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Director{directorId=").append(directorId);
        sb.append(", directorFname=").append(directorFname);
        sb.append(", directorLname=").append(directorLname);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.directorId);
        hash = 59 * hash + Objects.hashCode(this.directorFname);
        hash = 59 * hash + Objects.hashCode(this.directorLname);
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
        final Director other = (Director) obj;
        if (!Objects.equals(this.directorFname, other.directorFname)) {
            return false;
        }
        if (!Objects.equals(this.directorLname, other.directorLname)) {
            return false;
        }
        if (!Objects.equals(this.directorId, other.directorId)) {
            return false;
        }
        return true;
    }

    
    
}
