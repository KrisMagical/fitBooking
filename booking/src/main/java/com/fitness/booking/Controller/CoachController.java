package com.fitness.booking.Controller;

import com.fitness.booking.Dto.CoachProfileDTO;
import com.fitness.booking.Dto.CoachSessionDTO;
import com.fitness.booking.Service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @PostMapping("/profile")
    public ResponseEntity<CoachProfileDTO> saveProfile(@AuthenticationPrincipal(expression = "username") String username,
                                                       @RequestBody CoachProfileDTO dto) {
        return ResponseEntity.ok(coachService.createOrUpdateProfile(username, dto));
    }

    @PostMapping("/sessions")
    public ResponseEntity<CoachSessionDTO> createSession(@AuthenticationPrincipal(expression = "username") String username,
                                                         @RequestBody CoachSessionDTO dto) {
        return ResponseEntity.ok(coachService.createSession(username, dto));
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<CoachSessionDTO>> listMySessions(@AuthenticationPrincipal(expression = "username") String username) {
        return ResponseEntity.ok(coachService.listMySessions(username));
    }

    @PutMapping("/sessions/{id}")
    public ResponseEntity<CoachSessionDTO> updateSession(@PathVariable Long id,
                                                         @AuthenticationPrincipal(expression = "username") String username,
                                                         @RequestBody CoachSessionDTO dto) {
        return ResponseEntity.ok(coachService.updateSession(id, username, dto));
    }
}
