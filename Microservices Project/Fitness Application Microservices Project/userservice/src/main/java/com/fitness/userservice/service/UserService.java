package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterUserRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.entity.User;
import com.fitness.userservice.exception.EmailAlreadyExistsException;
import com.fitness.userservice.exception.UserNotFoundException;
import com.fitness.userservice.mapper.UserMapper;
import com.fitness.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserResponse register(RegisterUserRequest registerUserRequest) {
        if (userRepository.existsByEmail(registerUserRequest.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        User user = UserMapper.toUserEntity(registerUserRequest);
        User savedUser =  userRepository.save(user);
        return UserMapper.toUserResponse(savedUser);
    }

    public UserResponse getUserById(String id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with UserID: " + id + " doesn't exist"));
        return UserMapper.toUserResponse(user);
    }

    public Boolean existsByUserId(String userId) {
        return userRepository.existsById(userId);
    }
}
