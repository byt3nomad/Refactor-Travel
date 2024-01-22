package com.jordan.travel.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public Flux<ReservationGet> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ReservationGet> getById(@PathVariable Long id) {
        return reservationService.getById(id);
    }

    @PutMapping
    public Mono<Reservation> edit(@RequestBody ReservationCreate dto) {
        return reservationService.save(dto);
    }

    @PostMapping
    public Mono<Reservation> create(@RequestBody ReservationCreate dto) {
        return reservationService.save(dto);
    }
}
