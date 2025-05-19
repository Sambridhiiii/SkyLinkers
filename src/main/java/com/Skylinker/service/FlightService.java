package com.Skylinker.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.Skylinker.config.DbConfig;
import com.Skylinker.model.FlightModel;

public class FlightService {
    
    private Connection connection;
    
    public FlightService() {
        try {
            this.connection = DbConfig.getDbConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean addFlight(FlightModel flight) {
        String sql = "INSERT INTO Flight (Flight_No, Airline, Destination_From, Destination_To, " +
                    "Departure_Time, Arrival_Time, Aircraft, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, flight.getFlightNo());
            stmt.setString(2, flight.getAirline());
            stmt.setString(3, flight.getDestinationFrom());
            stmt.setString(4, flight.getDestinationTo());
            stmt.setTimestamp(5, Timestamp.valueOf(flight.getDepartureTime()));
            stmt.setTimestamp(6, Timestamp.valueOf(flight.getArrivalTime()));
            stmt.setString(7, flight.getAircraft());
            stmt.setString(8, flight.getStatus());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<FlightModel> getAllFlights() {
        List<FlightModel> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flight";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                FlightModel flight = new FlightModel();
                flight.setFlightId(rs.getInt("Flight_Id"));
                flight.setFlightNo(rs.getString("Flight_No"));
                flight.setAirline(rs.getString("Airline"));
                flight.setDestinationFrom(rs.getString("Destination_From"));
                flight.setDestinationTo(rs.getString("Destination_To"));
                flight.setDepartureTime(rs.getTimestamp("Departure_Time").toLocalDateTime());
                flight.setArrivalTime(rs.getTimestamp("Arrival_Time").toLocalDateTime());
                flight.setAircraft(rs.getString("Aircraft"));
                flight.setStatus(rs.getString("Status"));
                
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
    
    public boolean updateFlight(FlightModel flight) {
        String sql = "UPDATE Flight SET Flight_No = ?, Airline = ?, Destination_From = ?, " +
                     "Destination_To = ?, Departure_Time = ?, Arrival_Time = ?, " +
                     "Aircraft = ?, Status = ? WHERE Flight_Id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, flight.getFlightNo());
            stmt.setString(2, flight.getAirline());
            stmt.setString(3, flight.getDestinationFrom());
            stmt.setString(4, flight.getDestinationTo());
            stmt.setTimestamp(5, Timestamp.valueOf(flight.getDepartureTime()));
            stmt.setTimestamp(6, Timestamp.valueOf(flight.getArrivalTime()));
            stmt.setString(7, flight.getAircraft());
            stmt.setString(8, flight.getStatus());
            stmt.setInt(9, flight.getFlightId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteFlight(int flightId) {
        String sql = "DELETE FROM Flight WHERE Flight_Id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, flightId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public FlightModel getFlightById(int flightId) {
        String sql = "SELECT * FROM Flight WHERE Flight_Id = ?";
        FlightModel flight = null;
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, flightId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                flight = new FlightModel();
                flight.setFlightId(rs.getInt("Flight_Id"));
                flight.setFlightNo(rs.getString("Flight_No"));
                flight.setAirline(rs.getString("Airline"));
                flight.setDestinationFrom(rs.getString("Destination_From"));
                flight.setDestinationTo(rs.getString("Destination_To"));
                flight.setDepartureTime(rs.getTimestamp("Departure_Time").toLocalDateTime());
                flight.setArrivalTime(rs.getTimestamp("Arrival_Time").toLocalDateTime());
                flight.setAircraft(rs.getString("Aircraft"));
                flight.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }
}