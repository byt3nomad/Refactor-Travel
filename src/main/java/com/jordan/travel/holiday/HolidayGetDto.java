package com.jordan.travel.holiday;

import org.springframework.data.annotation.Id;

import com.jordan.travel.location.Location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HolidayGetDto {
    @Id
    private Long id;
    private Integer duration;
    private Integer freeSlots;
    private String price;
    private String startDate;
    private String title;
    private Location location;

    public static HolidayGetDto fromEntity(Holiday entity, Location location) {
        return HolidayGetDto.builder()//
                .id(entity.getId())
                .duration(entity.getDuration())
                .freeSlots(entity.getFreeSlots())
                .price(entity.getPrice().toString())
                .startDate(entity.getStartDate().toString())
                .title(entity.getTitle())
                .location(location)
                .build();
    }
}
