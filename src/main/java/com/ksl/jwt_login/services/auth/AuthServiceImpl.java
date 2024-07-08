package com.ksl.jwt_login.services.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ksl.jwt_login.dto.SignupDTO;
import com.ksl.jwt_login.dto.UserDTO;
import com.ksl.jwt_login.entities.User;
import com.ksl.jwt_login.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        User user = new User();
        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setPhone(signupDTO.getPhone());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setName(createdUser.getName());
        userDTO.setPhone(createdUser.getPhone());
        return userDTO;
    }
}