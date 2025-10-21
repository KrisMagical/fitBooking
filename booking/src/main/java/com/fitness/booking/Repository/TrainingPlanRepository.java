package com.fitness.booking.Repository;

import com.fitness.booking.Dto.TrainingPlanDTO;
import com.fitness.booking.Model.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan,Long> {
    List<TrainingPlan> findByMemberIdOrderByUpdatedAtDesc(Long memberId);
}
