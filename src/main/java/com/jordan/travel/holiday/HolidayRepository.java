package com.jordan.travel.holiday;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface HolidayRepository extends ReactiveCrudRepository<Holiday, Long> {

    Flux<Holiday> findByDuration(int duration);

    @Query("SELECT h.* FROM holiday h JOIN location l ON h.location_id = l.id WHERE l.city = :locationName OR l.country = :locationName")
    Flux<Holiday> findByLocationName(String locationName);

    @Query("SELECT h.* FROM holiday h JOIN location l ON h.location_id = l.id WHERE (l.city = :locationName OR l.country = :locationName) AND h.duration = :duration")
    Flux<Holiday> findByLocationNameAndDuration(String locationName, int duration);
}
