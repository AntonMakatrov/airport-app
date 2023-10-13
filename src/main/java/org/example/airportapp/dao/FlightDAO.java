package org.example.airportapp.dao;

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

    private final static String GET_ALL_FLIGHTS = "SELECT * FROM bookings.flights;";
    private final static String GET_PAGE_FLIGHTS = "SELECT * FROM bookings.flights LIMIT ? OFFSET ?;";
    private final static String GET_COUNT_FLIGHTS = "SELECT count(*) FROM bookings.flights;";

    List<Flight> data = new ArrayList<>();

    public FlightDAO() throws PropertyVetoException, SQLException, IOException {
    }

    public List<Flight> getAllFlights() throws SQLException {

        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_FLIGHTS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                data.add(map(resultSet));
            }
            return data;
        }
    }

    public List<Flight> getFilteredFlights(
            Timestamp fromDate,
            Timestamp toDate,
            String departureAirport,
            String arrivalAirport,
            String status,
            int page,
            int size) throws SQLException {

        try (Connection connection = ds.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT * FROM bookings.flights");
            // Add the WHERE clause only if at least one filter parameter is provided
            boolean whereClauseAdded = false;

            if (fromDate != null || toDate != null || (departureAirport != null && !departureAirport.isEmpty()) ||
                    (arrivalAirport != null && !arrivalAirport.isEmpty()) || (status != null && !status.isEmpty())) {
                sql.append(" WHERE");
                whereClauseAdded = true;
            }

            // Create a list to store filter conditions
            List<String> filterConditions = new ArrayList<>();

            if (fromDate != null) {
                filterConditions.add("scheduled_departure >= ?");
            }
            if (toDate != null) {
                filterConditions.add("scheduled_arrival <= ?");
            }
            if (departureAirport != null && !departureAirport.isEmpty()) {
                filterConditions.add("departure_airport = ?");
            }
            if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
                filterConditions.add("arrival_airport = ?");
            }
            if (status != null && !status.isEmpty()) {
                filterConditions.add("status = ?");
            }

            if (!filterConditions.isEmpty()) {
                // Join filter conditions with "AND" and append to the query
                sql.append(" ");
                sql.append(String.join(" AND ", filterConditions));

            }
            sql.append(" LIMIT ? OFFSET ?;");

            try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
                int parameterIndex = 0;
                if (fromDate != null) {
                    statement.setTimestamp(++parameterIndex, fromDate);
                }
                if (toDate != null) {
                    statement.setTimestamp(++parameterIndex, toDate);
                }
                if (departureAirport != null && !departureAirport.isEmpty()) {
                    statement.setString(++parameterIndex, departureAirport);
                }
                if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
                    statement.setString(++parameterIndex, arrivalAirport);
                }
                if (status != null && !status.isEmpty()) {
                    statement.setString(++parameterIndex, status);
                }
                int param = parameterIndex;
                statement.setInt(++param, size);
                statement.setInt(++param, ((page-1) * size));

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        data.add(map(resultSet));
                    }
                }
            }
        }

        return data;
    }

    @Override
    public List<Flight> getPage(int page, int size) {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PAGE_FLIGHTS);
             )
        {
            statement.setInt(1, size);
            statement.setInt(2, ((page-1) * size));

            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    data.add(map(rs));
                }
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Flight map(ResultSet resultSet) throws SQLException {
        Flight item = new Flight();
        item.setFlightId(resultSet.getInt("flight_id"));
        item.setFlightNo(resultSet.getString("flight_no"));
        item.setScheduledDeparture(resultSet.getTimestamp("scheduled_departure"));
        item.setScheduledArrival(resultSet.getTimestamp("scheduled_arrival"));
        item.setDepartureAirport(resultSet.getString("departure_airport"));
        item.setArrivalAirport(resultSet.getString("arrival_airport"));
        item.setStatus(resultSet.getString("status"));
        item.setAircraftCode(resultSet.getString("aircraft_code"));
        item.setActualDeparture(resultSet.getTimestamp("actual_departure"));
        item.setActualArrival(resultSet.getTimestamp("actual_arrival"));
        return item;
    }

    public int count() throws SQLException {
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_COUNT_FLIGHTS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        }
    }
}
