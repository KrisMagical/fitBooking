package com.fitness.booking.Controller;

import com.fitness.booking.Dto.*;
import com.fitness.booking.Service.CoachVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/coach-videos")
@RequiredArgsConstructor
public class CoachVideoController {

    private final CoachVideoService coachVideoService;

    @PostMapping
    public CoachVideoDTO create(@RequestBody CreateCoachVideoRequest req) {
        return coachVideoService.create(req);
    }

    @PutMapping("/{id}")
    public CoachVideoDTO update(
            @PathVariable Long id,
            @RequestBody UpdateCoachVideoRequest req
    ) {
        return coachVideoService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        coachVideoService.delete(id);
    }

    @GetMapping("/coach/{coachId}")
    public List<CoachVideoDTO> listByCoach(@PathVariable Long coachId) {
        return coachVideoService.listByCoach(coachId);
    }
    @GetMapping("/detail/{id}")
    public CoachVideoDTO getById(@PathVariable Long id) {
        return coachVideoService.getById(id);
    }
}

