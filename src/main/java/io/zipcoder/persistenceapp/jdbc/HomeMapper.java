package io.zipcoder.persistenceapp.jdbc;

import io.zipcoder.persistenceapp.models.Home;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeMapper implements RowMapper<Home> {
    @Override
    public Home mapRow(ResultSet resultSet, int i) throws SQLException {
        Home home = new Home();
        home.setId(resultSet.getInt("id"));
        home.setAddress(resultSet.getString("address"));
        home.setHomeNumber(resultSet.getString("homeNumber"));
        return home;
    }
}
