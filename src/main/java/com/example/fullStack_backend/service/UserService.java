package com.example.fullStack_backend.service;

import com.example.fullStack_backend.exception.UserNotFoundException;
import com.example.fullStack_backend.model.User;
import com.example.fullStack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public User addUser(User user){
        return repo.save(user);
    }
    public List<User> getAllUser(){
        return repo.findAll();
    }
    public User getUserById(Long id){
        return repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
    public User updateUser(User user, Long id){
        User existingUser = repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
        existingUser.setName(user.getName());
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        return repo.save(existingUser);
    }
    public void deleteUser(Long id) {
        if (!repo.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
