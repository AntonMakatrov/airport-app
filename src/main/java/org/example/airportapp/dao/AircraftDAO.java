package org.example.airportapp.dao;

import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.dao.api.IAircraftDao;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDAO implements IAircraftDao {

    private DataSource ds = DataSourceCreator.getInstance();

    private List<Aircraft> airCrafts;

    public AircraftDAO() throws PropertyVetoException, SQLException, IOException {
    }


    @Override
    public List<Aircraft> getAllAircrafts() throws SQLException {
        airCrafts = new ArrayList<>();

        String sql = "SELECT aircraft_code," +
                " model ->> lang() AS model," +
                " range FROM aircrafts_data;";


        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
             ResultSet resultSet = stm.executeQuery()) {
            while (resultSet.next()){
                airCrafts.add(new Aircraft(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
        }
        return airCrafts;
    }
}
