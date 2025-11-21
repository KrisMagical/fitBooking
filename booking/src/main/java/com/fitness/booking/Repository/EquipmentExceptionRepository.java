package com.fitness.booking.Repository;

import com.fitness.booking.Model.EquipmentException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentExceptionRepository
        extends JpaRepository<EquipmentException, Long> {

    List<EquipmentException> findAllByEquipmentId(Long facilityId);
}
