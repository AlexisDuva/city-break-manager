package com.example.city_break_manager.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class Trip {
    private final int id;
    private final City city;
    private final Date StartDate;
    private final Date endDate;
    private final int rating;
    private final String personalNotes;

    public Trip(int id, City city, Date startDate, Date endDate, int rating, String personalNotes) {
        this.id = id;
        this.city = city;
        StartDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.personalNotes = personalNotes;
    }
}
