package com.jordan.travel.location;

import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public Flux<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping
    public Mono<Location> createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @GetMapping("/{id}")
    public Mono<Location> getById(@PathVariable Long id) {
        return locationService.getById(id);
    }

    @PutMapping
    public Mono<Location> updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteLocation(@PathVariable String id) {
        return locationService.deleteLocation(id);
    }

}
