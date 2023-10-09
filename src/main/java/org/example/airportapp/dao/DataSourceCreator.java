package org.example.airportapp.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class DataSourceCreator {
    private static DataSourceCreator instance;
    private ComboPooledDataSource cpds;

    private DataSourceCreator() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        cpds.setUser("postgres");
        cpds.setPassword("1234");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance == null) {
            synchronized (DataSourceCreator.class){
                instance = new DataSourceCreator();
            }
        }
        return instance.cpds;
    }
}
