package com.fitness.booking.Service;

import com.fitness.booking.Dto.FacilityAvailabilityDTO;
import com.fitness.booking.Mapper.FacilityAvailabilityMapper;
import com.fitness.booking.Model.FacilityAvailability;
import com.fitness.booking.Repository.FacilityAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityAvailabilityService {

    private final FacilityAvailabilityRepository repository;
    private final FacilityAvailabilityMapper mapper;

    @Transactional
    public FacilityAvailabilityDTO create(FacilityAvailabilityDTO dto) {
        FacilityAvailability av = mapper.fromDto(dto);
        repository.save(av);
        return mapper.toDto(av);
    }

    @Transactional
    public FacilityAvailabilityDTO update(Long id, FacilityAvailabilityDTO dto) {
        FacilityAvailability av = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("记录不存在"));

        if (!av.getVersion().equals(dto.getVersion())) {
            throw new RuntimeException("数据已被修改，请刷新重试");
        }

        mapper.updateEntity(av, dto);
        repository.save(av);

        return mapper.toDto(av);
    }

    public List<FacilityAvailabilityDTO> list(Long facilityId) {
        return repository.findAllByFacilityId(facilityId)
                .stream().map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

