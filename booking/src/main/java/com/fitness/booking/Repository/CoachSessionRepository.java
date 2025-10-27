package com.fitness.booking.Repository;

import com.fitness.booking.Model.CoachSession;
import com.fitness.booking.Model.Enums.BookingStatus;
import com.fitness.booking.Model.Enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Repository
public interface CoachSessionRepository extends JpaRepository<CoachSession, Long> {
    List<CoachSession> findByCoachId(Long coachId);

    boolean existsByCoachIdAndStartTimeLessThanAndEndTimeGreaterThan(Long coachId, Instant end, Instant start);

    Collection<Object> findAllByCoachId(Long coachId);
}
