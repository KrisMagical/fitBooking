package com.fitness.booking.Controller;

import com.fitness.booking.Dto.BookingCancelRequest;
import com.fitness.booking.Dto.BookingCreateRequest;
import com.fitness.booking.Dto.BookingDTO;
import com.fitness.booking.Service.BookingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDTO> create(@RequestBody BookingCreateRequest request
            , @AuthenticationPrincipal(expression = "username") String username) {
        return new ResponseEntity<>(bookingService.create(request, username), HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<List<BookingDTO>> myBookings(@AuthenticationPrincipal(expression = "username") String username) {
        return new ResponseEntity<>(bookingService.getMyBookings(username), HttpStatus.OK);
    }

    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id,
                       @AuthenticationPrincipal(expression = "username") String username,
                       @RequestBody BookingCancelRequest request) {
        bookingService.cancel(id, username, request);
    }
}
