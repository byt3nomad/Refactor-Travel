package com.jordan.travel.holiday;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.jordan.travel.location.Location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HolidayDto {

    @Id
    private Long id;
    private Integer duration;
    private Integer freeSlots;
    private Long location;
    private String price;
    private String startDate;
    private String title;

    // public HolidayDto fromEntity(Holiday entity) {
    // return HolidayDto.builder()//
    // .id(entity.getId())
    // .duration(entity.getDuration())
    // .freeSlots(entity.getFreeSlots())
    // .price(entity.getPrice())
    // .startDate(LocalDate.parse(entity.getStartDate()))
    // .location(entity.getLocationId())
    // .title(entity.getTitle())
    // .build();
    // }
}
