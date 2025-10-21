package com.fitness.booking.Service;

import com.fitness.booking.Dto.TrainingPlanCreateRequest;
import com.fitness.booking.Dto.TrainingPlanDTO;
import com.fitness.booking.Dto.TrainingPlanUpdateRequest;
import com.fitness.booking.Mapper.TrainingPlanMapper;
import com.fitness.booking.Model.TrainingPlan;
import com.fitness.booking.Repository.TrainingPlanRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class TrainingPlanService {
    private TrainingPlanRepository trainingPlanRepository;
    private TrainingPlanMapper trainingPlanMapper;

    @Transactional
    public TrainingPlanDTO create(TrainingPlanCreateRequest request) {
        TrainingPlan trainingPlan = trainingPlanMapper.fromCreate(request);
        trainingPlanRepository.save(trainingPlan);
        return trainingPlanMapper.toDto(trainingPlan);
    }

    @Transactional
    public TrainingPlanDTO update(Long id, TrainingPlanUpdateRequest request) {
        TrainingPlan trainingPlan = trainingPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training Plan Not Exist"));
        trainingPlanMapper.update(trainingPlan, request);
        trainingPlanRepository.save(trainingPlan);
        return trainingPlanMapper.toDto(trainingPlan);
    }

    public List<TrainingPlanDTO> listByMember(Long memberId) {
        return trainingPlanRepository.findByMemberIdOrderByUpdatedAtDesc(memberId)
                .stream().map(trainingPlanMapper::toDto).collect(Collectors.toList());
    }
}
