package com.userordermanagement.mapper;

import com.userordermanagement.dto.UserDTO;
import com.userordermanagement.entity.User;

import java.util.stream.Collectors;

public class UserMapper {
    // UserDTO to UserEntity
    public static User toUserEntity(UserDTO  userDTO) {
        if(userDTO == null) return null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());

        // orders will be set from OrderMapper during order handling or service layer
        return user;
    }

    // UserEntity to UserDTO
    public static UserDTO toUserDTO(User  user) {
        if(user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());

        if (user.getOrders() != null) {
            userDTO.setOrders(user.getOrders().stream().map(OrderMapper::toOrderDTO).collect(Collectors.toList()));
        }
        return userDTO;
    }

}
