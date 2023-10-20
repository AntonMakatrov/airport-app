package org.example.airportapp.dao;

import org.example.airportapp.core.dto.Flight;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;
import org.example.airportapp.dao.api.IFlightDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {

    private final static String GET_ALL_FLIGHT = "SELECT flight_id, flight_no, scheduled_departure, scheduled_departure_local, scheduled_arrival, scheduled_arrival_local, scheduled_duration, departure_airport, departure_airport_name, departure_city, arrival_airport, arrival_airport_name, arrival_city, status, aircraft_code, actual_departure, actual_departure_local, actual_arrival, actual_arrival_local, actual_duration FROM bookings.flights_v";
    private final static String GET_COUNT_FLIGHT = "SELECT count(*) FROM bookings.flights_v;";

    private final DataSource dataSource;

    public FlightDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Flight> getAll() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stm = conn.prepareStatement(GET_ALL_FLIGHT);
             ResultSet rs = stm.executeQuery();)
        {
            List<Flight> data = new ArrayList<>();
            while (rs.next()){
                data.add(map(rs));
            }

            return data;
        } catch (SQLException e){
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return getPage(null, pageable);
    }

    @Override
    public List<Flight> getPage(FlightFilter filter, Pageable pageable) {
        String sql = GET_ALL_FLIGHT;

        List<Object> params = new ArrayList<>();
        if(filter != null){
            StringBuilder sqlBuilder = new StringBuilder();

            boolean needSeparator = false;
            if(filter.getArrivalAirport() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("arrival_airport = ?");
                params.add(filter.getArrivalAirport());
            }
            if(filter.getDepartureAirport() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("departure_airport = ?");
                params.add(filter.getDepartureAirport());
            }
            if(filter.getStatus() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("status = ?");
                params.add(filter.getStatus());
            }
            if(filter.getScheduledDeparture() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_departure >= ? AND scheduled_departure < ?");
                params.add(filter.getScheduledDeparture());
                params.add(filter.getScheduledDeparture().plusDays(1));
            }
            if(filter.getScheduledArrival() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_arrival >= ? AND scheduled_arrival < ?");
                params.add(filter.getScheduledArrival());
                params.add(filter.getScheduledArrival().plusDays(1));
            }

            if(sqlBuilder.length() > 0){
                sqlBuilder.insert(0, " WHERE ");
                sql += sqlBuilder.toString();
            }
        }

        if(pageable != null){
            int size = pageable.getSize();
            int page = pageable.getPage();

            sql += " LIMIT ? OFFSET ?";
            params.add(size);
            params.add(((page - 1) * size));
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
             )
        {
            int index = 1;
            for (Object param : params) {
                stm.setObject(index++, param);
            }

            try(ResultSet rs = stm.executeQuery();){
                List<Flight> data = new ArrayList<>();
                while (rs.next()){
                    data.add(map(rs));
                }

                return data;
            }
        } catch (SQLException e){
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    public int count(){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stm = conn.prepareStatement(GET_COUNT_FLIGHT);
             ResultSet rs = stm.executeQuery();)
        {
            while (rs.next()){
                return rs.getInt(1);
            }

            return 0;
        } catch (SQLException e){
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    public Flight map(ResultSet rs) throws SQLException {
        Flight item = new Flight();
        item.setFlightId(rs.getString("flight_id"));
        item.setFlightNo(rs.getString("flight_no"));
        item.setScheduledDeparture(rs.getString("scheduled_departure"));
        item.setScheduledDepartureLocal(rs.getString("scheduled_departure_local"));
        item.setScheduledArrival(rs.getString("scheduled_arrival"));
        item.setScheduledArrivalLocal(rs.getString("scheduled_arrival_local"));
        item.setScheduledDuration(rs.getString("scheduled_duration"));
        item.setDepartureAirport(rs.getString("departure_airport"));
        item.setDepartureAirportName(rs.getString("departure_airport_name"));
        item.setDepartureCity(rs.getString("departure_city"));
        item.setArrivalAirport(rs.getString("arrival_airport"));
        item.setArrivalAirportName(rs.getString("arrival_airport_name"));
        item.setArrivalCity(rs.getString("arrival_city"));
        item.setStatus(rs.getString("status"));
        item.setAircraftCode(rs.getString("aircraft_code"));
        item.setActualDeparture(rs.getString("actual_departure"));
        item.setActualDepartureLocal(rs.getString("actual_departure_local"));
        item.setActualArrival(rs.getString("actual_arrival"));

        return item;
    }
}
