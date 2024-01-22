package com.jordan.travel.holiday;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface HolidayRepository extends ReactiveCrudRepository<Holiday, Long> {

}
