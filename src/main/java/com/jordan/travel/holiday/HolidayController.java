package com.jordan.travel.holiday;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class HolidayController {

    private final HolidayService holidayService;

    @PostMapping
    public Mono<Holiday> create(@RequestBody HolidayDto holiday) {
        return holidayService.save(holiday);
    }

    @PutMapping
    public Mono<Holiday> edit(@RequestBody HolidayDto holiday) {
        return holidayService.save(holiday);
    }

    @GetMapping
    public Flux<HolidayGetDto> getAll() {
        return holidayService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<HolidayGetDto> getById(@PathVariable Long id) {
        return holidayService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return holidayService.deleteById(id);
    }
}
