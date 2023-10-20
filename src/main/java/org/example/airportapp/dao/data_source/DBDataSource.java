package org.example.airportapp.dao.data_source;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DBDataSource {

    private static ComboPooledDataSource ds;

    static {
        ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new IllegalStateException("Ошибка инициализации драйвера базы", e);
        }
        ds.setJdbcUrl( "jdbc:postgresql://localhost:5432/demo" );
        ds.setUser("postgres");
        ds.setPassword("1234");
    }

    public static DataSource getInstance(){
        return ds;
    }
}
