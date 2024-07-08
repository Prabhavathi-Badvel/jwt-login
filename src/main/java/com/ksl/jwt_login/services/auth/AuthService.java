package com.ksl.jwt_login.services.auth;

import com.ksl.jwt_login.dto.SignupDTO;
import com.ksl.jwt_login.dto.UserDTO;

;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}