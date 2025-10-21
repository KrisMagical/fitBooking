package com.fitness.booking.Controller;

import com.fitness.booking.Dto.TrainingPlanCreateRequest;
import com.fitness.booking.Dto.TrainingPlanDTO;
import com.fitness.booking.Dto.TrainingPlanUpdateRequest;
import com.fitness.booking.Service.TrainingPlanService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
@Data
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;

    @PostMapping
    public ResponseEntity<TrainingPlanDTO> create(@RequestBody TrainingPlanCreateRequest request) {
        return new ResponseEntity<>(trainingPlanService.create(request), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingPlanDTO> update(@PathVariable Long id,
                                                  @RequestBody TrainingPlanUpdateRequest request) {
        return new ResponseEntity<>(trainingPlanService.update(id, request), HttpStatus.OK);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<TrainingPlanDTO>> listByMember(@PathVariable Long memberId) {
        return new ResponseEntity<>(trainingPlanService.listByMember(memberId), HttpStatus.OK);
    }
}
