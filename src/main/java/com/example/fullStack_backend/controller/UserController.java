package com.example.fullStack_backend.controller;

import com.example.fullStack_backend.model.User;
import com.example.fullStack_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://crud-frontend-zeta-dusky.vercel.app"
})
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/")
    public String home() {
        return "Backend is running!";
    }
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(service.addUser(user), HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(service.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(service.updateUser(user,id),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }
}
