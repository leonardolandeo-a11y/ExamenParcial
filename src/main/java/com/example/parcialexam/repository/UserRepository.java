package com.example.parcialexam.repository;

import com.example.parcialexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String username);
    public Boolean existsByUsername(String username);
}
