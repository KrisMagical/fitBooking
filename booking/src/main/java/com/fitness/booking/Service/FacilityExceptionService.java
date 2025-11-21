package com.fitness.booking.Service;

import com.fitness.booking.Dto.FacilityExceptionDTO;
import com.fitness.booking.Mapper.FacilityExceptionMapper;
import com.fitness.booking.Model.FacilityException;
import com.fitness.booking.Repository.FacilityExceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityExceptionService {

    private final FacilityExceptionRepository repository;
    private final FacilityExceptionMapper mapper;

    @Transactional
    public FacilityExceptionDTO create(FacilityExceptionDTO dto) {
        FacilityException ex = mapper.fromDto(dto);
        repository.save(ex);
        return mapper.toDto(ex);
    }

    @Transactional
    public FacilityExceptionDTO update(Long id, FacilityExceptionDTO dto) {
        FacilityException ex = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("记录不存在"));

        if (!ex.getVersion().equals(dto.getVersion())) {
            throw new RuntimeException("数据已变更，请刷新");
        }

        mapper.updateEntity(ex, dto);
        repository.save(ex);

        return mapper.toDto(ex);
    }

    public List<FacilityExceptionDTO> list(Long facilityId) {
        return repository.findAllByFacilityId(facilityId)
                .stream().map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

