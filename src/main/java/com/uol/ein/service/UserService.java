package com.uol.ein.service;

import com.uol.ein.exception.UserNotFoundException;
import com.uol.ein.externalservice.IpVililanteService;
import com.uol.ein.model.Location;
import com.uol.ein.model.User;
import com.uol.ein.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long userId){
        Optional<User>  user = userRepository.findById(userId.intValue());
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found.");
        }
        return user.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user) { // TODO: Não esta atualizando direito
        User foundUser = findUserById(user.getId());
        foundUser = user;
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId.intValue());
    }
}
