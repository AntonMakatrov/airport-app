package org.example.airportapp.dao;

import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.dao.api.IAirportDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements IAirportDao {
    private DataSource ds = DataSourceCreator.getInstance();
    Airport airport = new Airport();
    List<Airport> airports = new ArrayList<>();

    public AirportDAO() throws PropertyVetoException, SQLException, IOException {
    }


    @Override
    public List<Airport> getAllAirports() throws SQLException {
        String sql = " SELECT airport_code,\n" +
                "    airport_name ->> lang() AS airport_name,\n" +
                "    city ->> lang() AS city,\n" +
                "    coordinates,\n" +
                "    timezone\n" +
                "   FROM airports_data ml;";

        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {

            while (resultSet.next()) {
                airport.setAirportCode(resultSet.getString(1));
                airport.setAirportName(resultSet.getString(2));
                airport.setCity(resultSet.getString(3));
                airport.setCoordinates(resultSet.getString(4));
                airport.setTimezone(resultSet.getString(5));
                airports.add(airport);
            }
            return airports;
        }
    }
}
