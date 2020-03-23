package com.interswitchgroup.crudwithsp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class config {

    @Value("${spring.datasource.url}")
    private String dbConnection;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String connectionDriver;


    @Bean
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(connectionDriver);
        dataSource.setUrl(dbConnection);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
