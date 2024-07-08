package com.ksl.jwt_login.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String identifier;

    private String password;

	

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}