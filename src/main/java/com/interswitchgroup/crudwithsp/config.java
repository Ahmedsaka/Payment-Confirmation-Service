package com.interswitchgroup.crudwithsp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class config {

    @Bean
    public DataSource sqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\ISW-ENGR-AS:1433;databaseName=test;integratedSecurity=false;");
        dataSource.setUsername("AppUser");
        dataSource.setPassword("Password12");
        return dataSource;
    }
}
