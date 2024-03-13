package com.tardisgallifrey;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

public class PSGL {

    public Connection connect(String databaseName) throws SQLException, IOException {
        HashMap<String, String> props = new HashMap<>();
        props = DatabaseConfig.DatabaseConfig("db.properties");

        //String jdbcUrl = "jdbc:postgresql://localhost:5432/";
        String jdbcUrl = props.get("db.url");
        String dbuser = props.get("db.username");
        String password = props.get("db.password");

        return DriverManager.getConnection(jdbcUrl+databaseName, dbuser, password);

    }

    public int addUser(String username, String database) {

        int success = 0;

        try(Connection token = this.connect(database)) {
            String insertQuery = "INSERT INTO users (username) VALUES (?)";
            PreparedStatement preparedStatement = token.prepareStatement(insertQuery);
            preparedStatement.setString(1,username);
            success = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            System.out.println("Method addUser could not connect.");
            System.out.println(e.getLocalizedMessage());
        }

        return success;
    }

    public ResultSet getAllUsers(String database) {
        ResultSet result = null;

        try(Connection token = this.connect(database)) {
            String selectQuery = "SELECT * FROM users";
            PreparedStatement preparedStatement = token.prepareStatement(selectQuery);
            result = preparedStatement.executeQuery();
            //do not close these or the result is useless
        } catch (SQLException | IOException e) {
            System.out.println("Method getUser could not connect.");
            System.out.println(e.getLocalizedMessage());
        }

        return result;
    }



}
