package com.airline.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Flight {

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departure;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date arrival;

    private String origin;
    private String destination;

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
