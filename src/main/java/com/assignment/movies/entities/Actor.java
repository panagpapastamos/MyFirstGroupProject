package com.assignment.movies.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name  = "actor_id")
    private Long actorId;

    @Column(name = "actor_Fname")
    private String actorFname;
    
    @Column(name = "actor_Lname")
    private String actorLname;
    
    @OneToMany(mappedBy ="actor" , cascade = CascadeType.ALL)
    private List <MovieCast> characters;

    public Actor() {
    }

    public Actor(Long actorId, String actorFname, String actorLname, List<MovieCast> characters) {
        this.actorId = actorId;
        this.actorFname = actorFname;
        this.actorLname = actorLname;
        this.characters = characters;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorFname() {
        return actorFname;
    }

    public void setActorFname(String actorFname) {
        this.actorFname = actorFname;
    }

    public String getActorLname() {
        return actorLname;
    }

    public void setActorLname(String actorLname) {
        this.actorLname = actorLname;
    }

    public List <MovieCast> getCharacters() {
        return characters;
    }

    public void setCharacters(List <MovieCast> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Actor{actorId=").append(actorId);
        sb.append(", actorFname=").append(actorFname);
        sb.append(", actorLname=").append(actorLname);
        sb.append(", characters=").append(characters);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.actorId);
        hash = 29 * hash + Objects.hashCode(this.actorFname);
        hash = 29 * hash + Objects.hashCode(this.actorLname);
        hash = 29 * hash + Objects.hashCode(this.characters);
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.actorFname, other.actorFname)) {
            return false;
        }
        if (!Objects.equals(this.actorLname, other.actorLname)) {
            return false;
        }
        if (!Objects.equals(this.actorId, other.actorId)) {
            return false;
        }
        if (!Objects.equals(this.characters, other.characters)) {
            return false;
        }
        return true;
    }

    
    
}
