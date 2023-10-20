package org.example.airportapp.dao.data_source;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFFactory {
    private static EntityManagerFactory instance;

    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("test");
        }
        return instance;
    }
}
