package com.fitness.booking.Controller;

import com.fitness.booking.Dto.LoginRequest;
import com.fitness.booking.Dto.LoginResponse;
import com.fitness.booking.Dto.RegisterRequest;
import com.fitness.booking.Service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Data
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        LoginResponse loginResponse = authService.register(request);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse loginResponse = authService.login(request);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }
}
