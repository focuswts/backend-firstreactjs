package br.com.bgt.firstsystem.db;

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;



@Configuration
public class MariaDB {



    @Bean
    MariaDB4jSpringService mariaDB4jSpringService() {
       return new MariaDB4jSpringService();
    }

    @Bean
    @DependsOn("mariaDB4jSpringService")
    DataSource dataSource(DataSourceProperties dataSourceProperties) {
        return DataSourceBuilder.create()
                .username("root")
                .password("1337")
                .url("jdbc:mariadb://localhost:3307/bgtparking?createDatabaseIfNotExist=true")
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }


}
