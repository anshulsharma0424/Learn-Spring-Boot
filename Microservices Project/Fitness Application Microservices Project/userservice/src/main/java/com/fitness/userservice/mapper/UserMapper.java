package com.fitness.userservice.mapper;

import com.fitness.userservice.dto.RegisterUserRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }

    public static User toUserEntity(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        // Role and timestamps will be handled separately

        return user;
    }
}
