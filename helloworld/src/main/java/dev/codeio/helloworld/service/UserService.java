package dev.codeio.helloworld.service;

import dev.codeio.helloworld.Models.Todo;
import dev.codeio.helloworld.Models.User;
import dev.codeio.helloworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }


}
