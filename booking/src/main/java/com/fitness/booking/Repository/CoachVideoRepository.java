package com.fitness.booking.Repository;

import com.fitness.booking.Model.CoachVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachVideoRepository extends JpaRepository<CoachVideo, Long> {

    List<CoachVideo> findAllByCoachId(Long coachId);
}

