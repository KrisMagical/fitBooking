package com.fitness.booking.Service;

import com.fitness.booking.Dto.BookingCancelRequest;
import com.fitness.booking.Dto.BookingCreateRequest;
import com.fitness.booking.Dto.BookingDTO;
import com.fitness.booking.Mapper.BookingMapper;
import com.fitness.booking.Model.Booking;
import com.fitness.booking.Model.Enums.BookingStatus;
import com.fitness.booking.Repository.BookingRepository;
import com.fitness.booking.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final BookingMapper bookingMapper;

    @Transactional
    public BookingDTO create(BookingCreateRequest request, String username) {
        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist")).getId();
        bookingRepository.findByIdempotencyKey(request.getIdempotencyKey())
                .ifPresent(b -> {
                    throw new RuntimeException("Duplicate submission");
                });
        Booking booking = bookingMapper.fromCreate(request);
        booking.setMemberId(memberId);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setPaymentStatus("PENDING");
        bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    public List<BookingDTO> getMyBookings(String username) {
        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist")).getId();
        return bookingRepository.findAllByMemberId(memberId)
                .stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void cancel(Long id, String username, BookingCancelRequest request) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment does not exist"));
        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist")).getId();
        if (!booking.getMemberId().equals(memberId)) {
            throw new RuntimeException("Cannot cancel other people's reservations");
        }
        booking.setBookingStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }
}
