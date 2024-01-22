package com.jordan.travel.reservation;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reservation {

    @Id
    private Long id;
    @Column("contactName")
    private String contactName;
    @Column("phoneNumber")
    private String phoneNumber;

    @Column("holiday_id")
    private Long holidayId;

    public static Reservation fromCreate(ReservationCreate create) {
        return Reservation.builder()//
                .id(create.getId())
                .contactName(create.getContactName())
                .phoneNumber(create.getPhoneNumber())
                .holidayId(create.getHoliday())
                .build();
    }
}