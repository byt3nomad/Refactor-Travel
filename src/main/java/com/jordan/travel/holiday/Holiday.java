package com.jordan.travel.holiday;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Holiday {

    @Id
    private Long id;
    private String title;

    @Column("startDate")
    private LocalDate startDate;
    private Integer duration;
    private BigDecimal price;
    @Column("freeSlots")
    private Integer freeSlots;

    @Column("location_id")
    private Long locationId;

    public static Holiday fromDto(HolidayDto dto) {
        return Holiday.builder()//
                .id(dto.getId())
                .duration(dto.getDuration())
                .freeSlots(dto.getFreeSlots())
                .price(new BigDecimal(dto.getPrice()))
                .startDate(LocalDate.parse(dto.getStartDate()))
                .title(dto.getTitle())
                .locationId(dto.getLocation())
                .build();
    }
}
