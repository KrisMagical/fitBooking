package com.fitness.booking.Service;

import com.fitness.booking.Dto.EquipmentExceptionDTO;
import com.fitness.booking.Mapper.EquipmentExceptionMapper;
import com.fitness.booking.Model.EquipmentException;
import com.fitness.booking.Repository.EquipmentExceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EquipmentExceptionService {

    private final EquipmentExceptionRepository repository;
    private final EquipmentExceptionMapper mapper;

    @Transactional
    public EquipmentExceptionDTO create(EquipmentExceptionDTO dto) {
        EquipmentException ex = mapper.fromDto(dto);
        repository.save(ex);
        return mapper.toDto(ex);
    }

    @Transactional
    public EquipmentExceptionDTO update(Long id, EquipmentExceptionDTO dto) {
        EquipmentException ex = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("记录不存在"));

        if (!ex.getVersion().equals(dto.getVersion())) {
            throw new RuntimeException("数据已变更，请刷新");
        }

        mapper.updateEntity(ex, dto);
        repository.save(ex);

        return mapper.toDto(ex);
    }

    public List<EquipmentExceptionDTO> list(Long facilityId) {
        return repository.findAllByEquipmentId(facilityId)
                .stream().map(mapper::toDto)
                .toList();
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}


