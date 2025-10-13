package com.daniela.product_api.repository;

import com.daniela.product_api.model.User;//importa la entidad User
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
}
