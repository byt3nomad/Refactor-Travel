package com.jordan.travel.holiday;

import org.springframework.data.annotation.Id;

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
}
