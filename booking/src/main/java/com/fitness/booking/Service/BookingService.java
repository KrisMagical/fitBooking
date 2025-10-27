package com.fitness.booking.Service;

import com.fitness.booking.Dto.BookingCancelRequest;
import com.fitness.booking.Dto.BookingCreateRequest;
import com.fitness.booking.Dto.BookingDTO;
import com.fitness.booking.Mapper.BookingMapper;
import com.fitness.booking.Model.Booking;
import com.fitness.booking.Model.CoachSession;
import com.fitness.booking.Model.Enums.BookingStatus;
import com.fitness.booking.Model.Enums.TargetType;
import com.fitness.booking.Repository.BookingRepository;
import com.fitness.booking.Repository.CoachSessionRepository;
import com.fitness.booking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final CoachSessionRepository coachSessionRepository;
    private final BookingMapper bookingMapper;

    @Transactional
    public BookingDTO create(BookingCreateRequest request, String username) {
        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在")).getId();

        bookingRepository.findByIdempotencyKey(request.getIdempotencyKey())
                .ifPresent(b -> {
                    throw new RuntimeException("重复提交预约");
                });

        if (request.getTargetType() != TargetType.COACH_SESSION) {
            throw new RuntimeException("暂不支持此类型预约");
        }

        CoachSession session = coachSessionRepository.findById(request.getTargetId())
                .orElseThrow(() -> new RuntimeException("私教时段不存在"));

        if (!"OPEN".equalsIgnoreCase(session.getStatus())) {
            throw new RuntimeException("该时段不可预约");
        }

        if (!session.getStartTime().equals(request.getStartTime())
                || !session.getEndTime().equals(request.getEndTime())) {
            throw new RuntimeException("预约时间与时段不匹配");
        }

        long confirmedCount = bookingRepository.countByTargetIdAndBookingStatus(session.getId(), BookingStatus.CONFIRMED);
        if (confirmedCount >= session.getCapacity()) {
            throw new RuntimeException("该时段名额已满");
        }

        Booking booking = bookingMapper.fromCreate(request);
        booking.setMemberId(memberId);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setPaymentStatus("PENDING");
        bookingRepository.save(booking);

        return bookingMapper.toDto(booking);
    }


    public List<BookingDTO> getMyBookings(String username) {
        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在")).getId();

        return bookingRepository.findAllByMemberId(memberId)
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional
    public void cancel(Long id, String username, BookingCancelRequest request) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("预约记录不存在"));

        Long memberId = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在")).getId();

        if (!booking.getMemberId().equals(memberId)) {
            throw new RuntimeException("不可取消他人预约");
        }

        if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("该预约已取消");
        }

        booking.setBookingStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }
}
