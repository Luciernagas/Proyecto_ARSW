package com.project.arswbackend.services;

import com.project.arswbackend.entities.User;
import com.project.arswbackend.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        user.setPassword(
                DigestUtils.sha256Hex(user.getPassword())
        );
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(String id){
        return userRepository.findById(id);
    }
}
