package com.fitness.booking.Controller;

import com.fitness.booking.Dto.FacilityAvailabilityDTO;
import com.fitness.booking.Service.FacilityAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/facility/availability")
@RequiredArgsConstructor
public class FacilityAvailabilityController {

    private final FacilityAvailabilityService service;

    @PostMapping
    public FacilityAvailabilityDTO create(@RequestBody FacilityAvailabilityDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public FacilityAvailabilityDTO update(
            @PathVariable Long id,
            @RequestBody FacilityAvailabilityDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{facilityId}")
    public List<FacilityAvailabilityDTO> list(@PathVariable Long facilityId) {
        return service.list(facilityId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

