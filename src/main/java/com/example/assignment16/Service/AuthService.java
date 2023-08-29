package com.example.assignment16.Service;


import com.example.assignment16.Model.User;
import com.example.assignment16.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    public void register(User user){
        String hash=new BCryptPasswordEncoder().encode(user.getPassword());;
        user.setRole("USER");
        user.setPassword(hash);
        authRepository.save(user);
    }
}
