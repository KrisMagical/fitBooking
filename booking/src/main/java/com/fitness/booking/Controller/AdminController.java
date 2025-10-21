package com.fitness.booking.Controller;

import com.fitness.booking.Dto.CreateUserRequest;
import com.fitness.booking.Dto.UpdateUserRoleRequest;
import com.fitness.booking.Dto.UserDTO;
import com.fitness.booking.Service.AdminService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Data
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/users")
    public ResponseEntity<UserDTO> create(@RequestBody CreateUserRequest request) {
        return new ResponseEntity<>(adminService.createUser(request), HttpStatus.OK);
    }

    @PutMapping("/users/{id}/role")
    public ResponseEntity<UserDTO> updateRole(@PathVariable Long id, @RequestBody UpdateUserRoleRequest request) {
        return new ResponseEntity<>(adminService.updateUser(id, request), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(adminService.listUsers(), HttpStatus.OK);
    }
}
