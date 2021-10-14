package com.assignment.movies.services;

import com.assignment.movies.entities.User;
import com.assignment.movies.repositories.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User findByUserName(String username) {
        return(userRepository.findByUserName(username));
    }
    
    public User findByEmail(String email){
        return (userRepository.findByEmail(email));
    }
    
    public boolean insertUser(User user) {
        return userRepository.save(user).getUsername().isEmpty();
    }
    
    //We use this method to change only the email of the user to fix the problem of the code we used in the controller
    public boolean updateUserEmail(User user){
        User user1 = userRepository.findByUserName(user.getUsername());
        user1.setEmail(user.getEmail());
        userRepository.saveAndFlush(user1);
        return true;
    }
    
    public boolean deleteUser(String username){
        User user = userRepository.findByUserName(username);
        userRepository.delete(user);
        return true;
    }
    
    //The method the admin will use to change the field enable dof the user to true or false depending on what it is
    //when the method is called
    public boolean updateUserEnabled(String username){
        User user = userRepository.findByUserName(username);
        if (user.isEnabled()){
        user.setEnabled(false);
        }
        else{
            user.setEnabled(true);
        }
        userRepository.saveAndFlush(user);
        return true;
    }
}
