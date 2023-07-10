package com.project.arswbackend.repository;

import com.project.arswbackend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username);
}
