package com.example.assignment16.Controller;


import com.example.assignment16.Api.ApiResponse;
import com.example.assignment16.Model.User;
import com.example.assignment16.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user){
        authService.register(user);
        return ResponseEntity.status(200).body(new ApiResponse("User registered"));
    }
    @GetMapping("/logout")
    public ResponseEntity logout(@RequestBody @Valid User user){
        return ResponseEntity.status(200).body(new ApiResponse("Logout"));
    }


}
