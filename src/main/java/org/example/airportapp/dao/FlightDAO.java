package org.example.airportapp.dao;

import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.dao.api.IFlightDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements IFlightDao {
    private DataSource ds = DataSourceCreator.getInstance();

    List<Flight> flights = new ArrayList<>();

    public FlightDAO() throws PropertyVetoException, SQLException, IOException {
    }

    public List<Flight> getAllFlights() throws SQLException {

        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM bookings.flights");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getInt("flight_id"));
                flight.setFlightNo(resultSet.getString("flight_no"));
                flight.setScheduledDeparture(resultSet.getTimestamp("scheduled_departure"));
                flight.setScheduledArrival(resultSet.getTimestamp("scheduled_arrival"));
                flight.setDepartureAirport(resultSet.getString("departure_airport"));
                flight.setArrivalAirport(resultSet.getString("arrival_airport"));
                flight.setStatus(resultSet.getString("status"));
                flight.setAircraftCode(resultSet.getString("aircraft_code"));
                flight.setActualDeparture(resultSet.getTimestamp("actual_departure"));
                flight.setActualArrival(resultSet.getTimestamp("actual_arrival"));
                flights.add(flight);
            }
            return flights;
        }
    }

    public List<Flight> getFilteredFlights(
            Timestamp fromDate,
            Timestamp toDate,
            String departureAirport,
            String arrivalAirport,
            String status) throws SQLException {

        try (Connection connection = ds.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM bookings.flights WHERE 1=1");

            // Добавляем условия фильтрации, если параметры заданы
            if (fromDate != null) {
                sql.append(" AND scheduled_departure >= ?");
            }
            if (toDate != null) {
                sql.append(" AND scheduled_arrival <= ?");
            }
            if (departureAirport != null && !departureAirport.isEmpty()) {
                sql.append(" AND departure_airport = ?");
            }
            if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
                sql.append(" AND arrival_airport = ?");
            }
            if (status != null && !status.isEmpty()) {
                sql.append(" AND status = ?");
            }

            try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
                int parameterIndex = 1;
                if (fromDate != null) {
                    statement.setTimestamp(parameterIndex++, fromDate);
                }
                if (toDate != null) {
                    statement.setTimestamp(parameterIndex++, toDate);
                }
                if (departureAirport != null && !departureAirport.isEmpty()) {
                    statement.setString(parameterIndex++, departureAirport);
                }
                if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
                    statement.setString(parameterIndex++, arrivalAirport);
                }
                if (status != null && !status.isEmpty()) {
                    statement.setString(parameterIndex, status);
                }

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Flight flight = new Flight();
                        flight.setFlightId(resultSet.getInt("flight_id"));
                        flight.setFlightNo(resultSet.getString("flight_no"));
                        flight.setScheduledDeparture(resultSet.getTimestamp("scheduled_departure"));
                        flight.setScheduledArrival(resultSet.getTimestamp("scheduled_arrival"));
                        flight.setDepartureAirport(resultSet.getString("departure_airport"));
                        flight.setArrivalAirport(resultSet.getString("arrival_airport"));
                        flight.setStatus(resultSet.getString("status"));
                        flight.setAircraftCode(resultSet.getString("aircraft_code"));
                        flight.setActualDeparture(resultSet.getTimestamp("actual_departure"));
                        flight.setActualArrival(resultSet.getTimestamp("actual_arrival"));
                        flights.add(flight);
                    }
                }
            }
        }

        return flights;
    }

}
