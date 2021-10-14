package com.assignment.movies.repositories;

import com.assignment.movies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUserName(String username);
    
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);
    
}
