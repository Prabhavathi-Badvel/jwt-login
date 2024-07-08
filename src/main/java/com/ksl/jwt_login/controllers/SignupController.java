package com.ksl.jwt_login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ksl.jwt_login.dto.SignupDTO;
import com.ksl.jwt_login.dto.UserDTO;
import com.ksl.jwt_login.services.auth.AuthService;

@RestController
public class SignupController {

    @Autowired
    private AuthService authService;
   

    @PostMapping("/sign-up")//Maps the HTTP POST request to save signupUser() method
    
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
       UserDTO createdUser = authService.createUser(signupDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
