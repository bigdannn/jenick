package com.cool.application.db.postgres;

import com.cool.application.db.DbConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnectionProviderImpl implements DbConnectionProvider {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/coolcats", "bogdamn", "1q2w3e4r5tbv");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}