package com.example.demo.repository;

import com.example.demo.Entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
