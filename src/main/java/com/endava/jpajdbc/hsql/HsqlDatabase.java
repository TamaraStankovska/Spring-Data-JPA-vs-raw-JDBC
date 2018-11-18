package com.endava.jpajdbc.hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDatabase {
    public Connection conn;

    // Connecting to database =>
    // Executing Query
    public HsqlDatabase() {
        try {
            loadJdbcDriverForHsqlDb();
            setupConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void setupConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/tamara", "root", "admin*");
    }

    private void loadJdbcDriverForHsqlDb() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    private void shutdownHsqlDatabase() throws SQLException {
        Statement st = conn.createStatement();
        st.execute("SHUTDOWN");
    }

    public void closeConnection() throws SQLException {
        shutdownHsqlDatabase();
        conn.close(); // if there are no other open connection
    }

}
