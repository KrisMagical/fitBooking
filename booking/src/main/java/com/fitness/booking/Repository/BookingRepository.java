package com.fitness.booking.Repository;

import com.fitness.booking.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Object> findByIdempotencyKey(String idempotencyKey);

    Collection<Booking> findAllByMemberId(Long memberId);
}
