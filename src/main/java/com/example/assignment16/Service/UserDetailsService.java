package com.example.assignment16.Service;

import com.example.assignment16.Api.ApiException;
import com.example.assignment16.Model.User;
import com.example.assignment16.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=authRepository.findUserByUsername(username);
        if (user==null)
            throw new ApiException("Wrong Username or Password");
        return user;
    }
}
