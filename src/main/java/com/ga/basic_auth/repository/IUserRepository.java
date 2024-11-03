package com.ga.basic_auth.repository;

import com.ga.basic_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String name);
    public boolean existsByEmail(String email);
}
