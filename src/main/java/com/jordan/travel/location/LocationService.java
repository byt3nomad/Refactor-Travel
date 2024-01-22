package com.jordan.travel.location;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Flux<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Mono<Location> getById(Long id) {
        return locationRepository.findById(id);
    }

    public Mono<Location> createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Mono<Location> updateLocation(Location updatedLocation) {
        return locationRepository.save(updatedLocation);
    }

    public Mono<Void> deleteLocation(String id) {
        return locationRepository.deleteById(Long.parseLong(id));
    }

}
