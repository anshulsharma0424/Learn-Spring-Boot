package com.Product.service;

import com.Product.entity.User;
import com.Product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) throw new UsernameNotFoundException("User not found with username: " + username);
        return
    }
}
