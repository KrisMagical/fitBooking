package com.fitness.booking.Repository;

import com.fitness.booking.Model.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession,Long> {
}
