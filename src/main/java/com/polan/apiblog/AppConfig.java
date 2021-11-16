package com.polan.apiblog;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.polan.apiblog")
@PropertySource("classPath:database.properties")
public class AppConfig {
    
    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName(environment.getProperty("driver"));
        dmds.setUrl(environment.getProperty("url"));
        dmds.setUsername(environment.getProperty("user"));
        dmds.setPassword(environment.getProperty("password"));

        return dmds;
    }
}
