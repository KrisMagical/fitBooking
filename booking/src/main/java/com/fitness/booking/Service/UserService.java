package com.fitness.booking.Service;

import com.fitness.booking.Dto.UpdateUserDTO;
import com.fitness.booking.Dto.UserDTO;
import com.fitness.booking.Mapper.UserMapper;
import com.fitness.booking.Model.User;
import com.fitness.booking.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getMe(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist"));
        return userMapper.toDto(user);
    }

    public UserDTO updateMe(String username, UpdateUserDTO dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist"));
        userMapper.updateEntity(user, dto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

}
