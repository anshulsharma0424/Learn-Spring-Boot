package com.userordermanagement.service;

import com.userordermanagement.dto.UserDTO;
import com.userordermanagement.entity.User;
import com.userordermanagement.exception.UserAlreadyExistsException;
import com.userordermanagement.exception.UserNotFoundException;
import com.userordermanagement.mapper.UserMapper;
import com.userordermanagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    // Create new user
    public UserDTO createUser(UserDTO userDTO){

        // check if the username and email already exists
        Optional<User> existingUser = userRepository.findByUsername(userDTO.getUsername());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("Username: " + userDTO.getUsername() + " already exists.");
        }
        existingUser = userRepository.findByEmail(userDTO.getEmail());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("Email: " + userDTO.getEmail() + " already exists.");
        }

        User user = UserMapper.toUserEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    // Get all users
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toUserDTO).toList();
    }

    // Get user by userId
    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserMapper.toUserDTO(user);
    }

    // Update user
    public UserDTO updateUser(Long id, UserDTO userDTO){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        user = userRepository.save(user);
        return UserMapper.toUserDTO(user);
    }

    // Delete user
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "User with id: " + id + " has been deleted";
    }

}
