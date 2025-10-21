package com.fitness.booking.Controller;

import com.fitness.booking.Dto.CourseDTO;
import com.fitness.booking.Dto.CourseSessionDTO;
import com.fitness.booking.Model.Course;
import com.fitness.booking.Service.CoachService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/api/coach")
public class CoachController {
    private final CoachService coachService;

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO dto) {
        return new ResponseEntity<>(coachService.createCourse(dto), HttpStatus.OK);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO dto) {
        return new ResponseEntity<>(coachService.updateCourse(id, dto), HttpStatus.OK);
    }

    @PostMapping("/sessions")
    public ResponseEntity<CourseSessionDTO> createSession(@RequestBody CourseSessionDTO dto) {
        return new ResponseEntity<>(coachService.createSession(dto), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> listCourses() {
        return new ResponseEntity<>(coachService.listCourses(), HttpStatus.OK);
    }
}
