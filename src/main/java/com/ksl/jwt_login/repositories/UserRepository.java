package com.ksl.jwt_login.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksl.jwt_login.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
    User findFirstByPhone(String phone);
}