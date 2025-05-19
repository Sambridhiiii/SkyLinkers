package com.Skylinker.model;

import java.time.LocalDateTime;

/**
 * FlightModel represents the flight entity with details such as
 * flight number, airline, origin and destination airports,
 * scheduled departure and arrival times, aircraft type, and status.
 */
public class FlightModel {
    private int flightId;
    private String flightNo;
    private String airline;
    private String destinationFrom;
    private String destinationTo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String aircraft;
    private String status;

    /**
     * Default constructor.
     */
    public FlightModel() {}

    /**
     * Parameterized constructor to create a FlightModel with all attributes.
     *
     * @param flightId         Unique identifier for the flight
     * @param flightNo         Flight number (e.g., "SK123")
     * @param airline          Airline operating the flight
     * @param destinationFrom  Origin airport or city
     * @param destinationTo    Destination airport or city
     * @param departureTime    Scheduled departure date and time
     * @param arrivalTime      Scheduled arrival date and time
     * @param aircraft         Aircraft model or type
     * @param status           Flight status (e.g., "On Time", "Delayed")
     */
    public FlightModel(int flightId, String flightNo, String airline, String destinationFrom, String destinationTo,
                       LocalDateTime departureTime, LocalDateTime arrivalTime, String aircraft, String status) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.airline = airline;
        this.destinationFrom = destinationFrom;
        this.destinationTo = destinationTo;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraft = aircraft;
        this.status = status;
    }

    // Getters and Setters

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDestinationFrom() {
        return destinationFrom;
    }

    public void setDestinationFrom(String destinationFrom) {
        this.destinationFrom = destinationFrom;
    }

    public String getDestinationTo() {
        return destinationTo;
    }

    public void setDestinationTo(String destinationTo) {
        this.destinationTo = destinationTo;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
