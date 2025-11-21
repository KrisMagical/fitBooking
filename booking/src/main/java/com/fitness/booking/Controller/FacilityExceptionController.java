package com.fitness.booking.Controller;

import com.fitness.booking.Dto.FacilityExceptionDTO;
import com.fitness.booking.Service.FacilityExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/facility/exception")
@RequiredArgsConstructor
public class FacilityExceptionController {

    private final FacilityExceptionService service;

    @PostMapping
    public FacilityExceptionDTO create(@RequestBody FacilityExceptionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public FacilityExceptionDTO update(
            @PathVariable Long id,
            @RequestBody FacilityExceptionDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{facilityId}")
    public List<FacilityExceptionDTO> list(@PathVariable Long facilityId) {
        return service.list(facilityId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

