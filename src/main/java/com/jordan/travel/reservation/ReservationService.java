package com.jordan.travel.reservation;

import org.springframework.stereotype.Service;

import com.jordan.travel.holiday.HolidayService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final HolidayService holidayService;

    public Mono<Reservation> save(ReservationCreate create) {
        return repository.save(Reservation.fromCreate(create));
    }

    public Flux<ReservationGet> getAll() {
        return repository.findAll().flatMap(r -> holidayService.getById(r.getHolidayId())
                .map(location -> ReservationGet.fromReservation(r, location)));
    }

    public Mono<ReservationGet> getById(Long id) {
        return repository.findById(id).flatMap(r -> holidayService.getById(r.getHolidayId())
                .map(location -> ReservationGet.fromReservation(r, location)));
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }
}
