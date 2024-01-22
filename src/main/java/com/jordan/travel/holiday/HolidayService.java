package com.jordan.travel.holiday;

import org.springframework.stereotype.Service;

import com.jordan.travel.location.LocationService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HolidayService {
    private final HolidayRepository holidayRepository;
    private final LocationService locationService;

    public Mono<Holiday> save(HolidayDto holiday) {
        return this.holidayRepository.save(Holiday.fromDto(holiday));
    }

    public Flux<HolidayGetDto> getAll() {
        return this.holidayRepository.findAll()
                .flatMap(holiday -> locationService.getById(holiday.getLocationId())
                        .map(location -> HolidayGetDto.fromEntity(holiday, location)));

    }

    public Mono<HolidayGetDto> getById(Long id) {
        return this.holidayRepository.findById(id).flatMap(holiday -> locationService.getById(holiday.getLocationId())
                .map(location -> HolidayGetDto.fromEntity(holiday, location)));
    }

    public Mono<Void> deleteById(Long id) {
        return this.holidayRepository.deleteById(id);
    }
}
