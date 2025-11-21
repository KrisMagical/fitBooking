package com.fitness.booking.Controller;

import com.fitness.booking.Dto.EquipmentAvailabilityDTO;
import com.fitness.booking.Service.EquipmentAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/facility/availability")
@RequiredArgsConstructor
public class EquipmentAvailabilityController {

    private final EquipmentAvailabilityService service;

    @PostMapping
    public EquipmentAvailabilityDTO create(@RequestBody EquipmentAvailabilityDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public EquipmentAvailabilityDTO update(
            @PathVariable Long id,
            @RequestBody EquipmentAvailabilityDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{facilityId}")
    public List<EquipmentAvailabilityDTO> list(@PathVariable Long facilityId) {
        return service.list(facilityId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

