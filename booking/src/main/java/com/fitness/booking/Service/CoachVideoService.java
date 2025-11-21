package com.fitness.booking.Service;

import com.fitness.booking.Dto.*;
import com.fitness.booking.Mapper.CoachVideoMapper;
import com.fitness.booking.Model.CoachVideo;
import com.fitness.booking.Repository.CoachVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachVideoService {

    private final CoachVideoRepository repository;
    private final CoachVideoMapper mapper;

    @Transactional
    public CoachVideoDTO create(CreateCoachVideoRequest req) {
        CoachVideo video = mapper.fromCreate(req);
        repository.save(video);
        return mapper.toDto(video);
    }

    @Transactional
    public CoachVideoDTO update(Long id, UpdateCoachVideoRequest req) {
        CoachVideo video = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("视频不存在"));

        if (!video.getVersion().equals(req.getVersion())) {
            throw new RuntimeException("数据已被更改，请刷新后重试");
        }

        mapper.updateEntity(video, req);
        repository.save(video);

        return mapper.toDto(video);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<CoachVideoDTO> listByCoach(Long coachId) {
        return repository.findAllByCoachId(coachId).stream()
                .map(mapper::toDto)
                .toList();
    }

    public CoachVideoDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("视频不存在"));
    }
}
