package com.fitness.booking.Service;

import com.fitness.booking.Dto.EquipmentAvailabilityDTO;
import com.fitness.booking.Mapper.EquipmentAvailabilityMapper;
import com.fitness.booking.Model.EquipmentAvailability;
import com.fitness.booking.Repository.EquipmentAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EquipmentAvailabilityService {

    private final EquipmentAvailabilityRepository repository;
    private final EquipmentAvailabilityMapper mapper;

    @Transactional
    public EquipmentAvailabilityDTO create(EquipmentAvailabilityDTO dto) {
        EquipmentAvailability av = mapper.fromDto(dto);
        repository.save(av);
        return mapper.toDto(av);
    }

    @Transactional
    public EquipmentAvailabilityDTO update(Long id, EquipmentAvailabilityDTO dto) {
        EquipmentAvailability av = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("记录不存在"));

        if (!av.getVersion().equals(dto.getVersion())) {
            throw new RuntimeException("数据已被修改，请刷新重试");
        }

        mapper.updateEntity(av, dto);
        repository.save(av);

        return mapper.toDto(av);
    }

    public List<EquipmentAvailabilityDTO> list(Long facilityId) {
        return repository.findAllByEquipmentId(facilityId)
                .stream().map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
