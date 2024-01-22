package com.jordan.travel.location;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Location {
    @Id
    private Long id;
    private String street;
    private String number;
    private String city;
    private String country;
}
