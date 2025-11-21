package com.fitness.booking.Controller;

import com.fitness.booking.Dto.EquipmentExceptionDTO;
import com.fitness.booking.Service.EquipmentExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/facility/exception")
@RequiredArgsConstructor
public class EquipmentExceptionController {

    private final EquipmentExceptionService service;

    @PostMapping
    public EquipmentExceptionDTO create(@RequestBody EquipmentExceptionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public EquipmentExceptionDTO update(
            @PathVariable Long id,
            @RequestBody EquipmentExceptionDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping("/{facilityId}")
    public List<EquipmentExceptionDTO> list(@PathVariable Long facilityId) {
        return service.list(facilityId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
