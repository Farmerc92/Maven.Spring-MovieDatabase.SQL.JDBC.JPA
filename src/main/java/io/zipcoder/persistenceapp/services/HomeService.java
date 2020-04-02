package io.zipcoder.persistenceapp.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb", "sa","");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


}
