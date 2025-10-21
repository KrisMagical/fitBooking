package com.fitness.booking.Service;

import com.fitness.booking.Dto.CreateUserRequest;
import com.fitness.booking.Dto.UpdateUserRoleRequest;
import com.fitness.booking.Dto.UserDTO;
import com.fitness.booking.Mapper.UserMapper;
import com.fitness.booking.Model.User;
import com.fitness.booking.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDTO createUser(CreateUserRequest request) {
        User user = userMapper.fromAdminCreate(request);
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDTO updateUser(Long id, UpdateUserRoleRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not exist"));
        user.setRole(request.getRole());
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
