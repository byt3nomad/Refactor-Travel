package com.jordan.travel.holiday;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Flux<HolidayGetDto> findHolidays(String locationName, Integer duration) {
        if (locationName != null && !locationName.isEmpty() && duration != null) {
            // Both location and duration are provided
            return holidayRepository.findByLocationNameAndDuration(locationName, duration)
                    .flatMap(holiday -> combineHolidayWithLocation(holiday));
        } else if (locationName != null && !locationName.isEmpty()) {
            // Only location is provided
            return holidayRepository.findByLocationName(locationName)
                    .flatMap(holiday -> combineHolidayWithLocation(holiday));
        } else if (duration != null) {
            // Only duration is provided
            return holidayRepository.findByDuration(duration)
                    .flatMap(holiday -> combineHolidayWithLocation(holiday));
        } else {
            // No filters are provided
            return holidayRepository.findAll()
                    .flatMap(holiday -> combineHolidayWithLocation(holiday));
        }
    }

    private Mono<HolidayGetDto> combineHolidayWithLocation(Holiday holiday) {
        return locationService.getById(holiday.getLocationId())
                .map(location -> HolidayGetDto.fromEntity(holiday, location));
    }

}
