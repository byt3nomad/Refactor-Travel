package com.jordan.travel.location;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LocationRepository extends ReactiveCrudRepository<Location, Long> {

}
