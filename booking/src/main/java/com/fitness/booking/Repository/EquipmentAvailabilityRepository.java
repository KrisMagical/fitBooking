package com.fitness.booking.Repository;

import com.fitness.booking.Model.EquipmentAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface EquipmentAvailabilityRepository
        extends JpaRepository<EquipmentAvailability, Long> {

    List<EquipmentAvailability> findAllByEquipmentId(Long facilityId);

}
