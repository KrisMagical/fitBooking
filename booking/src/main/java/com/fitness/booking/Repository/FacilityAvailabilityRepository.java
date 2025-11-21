package com.fitness.booking.Repository;

import com.fitness.booking.Model.FacilityAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityAvailabilityRepository
        extends JpaRepository<FacilityAvailability, Long> {

    List<FacilityAvailability> findAllByFacilityId(Long facilityId);
}

