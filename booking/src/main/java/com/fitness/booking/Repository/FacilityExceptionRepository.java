package com.fitness.booking.Repository;

import com.fitness.booking.Model.FacilityException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityExceptionRepository
        extends JpaRepository<FacilityException, Long> {

    List<FacilityException> findAllByFacilityId(Long facilityId);
}
