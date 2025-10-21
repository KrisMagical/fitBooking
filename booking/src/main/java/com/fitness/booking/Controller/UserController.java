package com.fitness.booking.Controller;

import com.fitness.booking.Dto.UpdateUserDTO;
import com.fitness.booking.Dto.UserDTO;
import com.fitness.booking.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/api/user/me")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserDTO> getMe(@AuthenticationPrincipal(expression = "username") String username) {
        return new ResponseEntity<>(userService.getMe(username), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateMe(@AuthenticationPrincipal(expression = "username") String username, @RequestBody UpdateUserDTO dto) {
        return new ResponseEntity<>(userService.updateMe(username, dto), HttpStatus.OK);
    }
}
