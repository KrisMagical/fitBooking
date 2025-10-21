package com.fitness.booking.Service;

import com.fitness.booking.Config.JWTService;
import com.fitness.booking.Dto.LoginRequest;
import com.fitness.booking.Dto.LoginResponse;
import com.fitness.booking.Dto.RegisterRequest;
import com.fitness.booking.Mapper.UserMapper;
import com.fitness.booking.Model.Enums.Role;
import com.fitness.booking.Model.Enums.UserStatus;
import com.fitness.booking.Model.User;
import com.fitness.booking.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Data
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @Transactional
    public LoginResponse register(RegisterRequest request) {
        if (userRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("Mobile phone number has been register");
        }
        User user = userMapper.fromRegister(request);
        user.setRole(Role.MEMBER);
        user.setUserStatus(UserStatus.ACTIVE);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());
        return new LoginResponse(token, userMapper.toDto(user));
    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByPhone(request.getPhoneOrUsername())
                .or(() -> userRepository.findByUsername(request.getPhoneOrUsername()))
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        if (!passwordEncoder.matches(request.getPassword(), user.getUsername())) {
            throw new RuntimeException("Incorrect Password");
        }
        String token = jwtService.generateToken(user.getUsername());
        return new LoginResponse(token, userMapper.toDto(user));
    }
}
