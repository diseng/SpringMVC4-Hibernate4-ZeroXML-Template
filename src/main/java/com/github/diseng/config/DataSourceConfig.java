package com.github.diseng.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by dengqinglin on 14-4-4.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.driverClass}") String driverClass;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.user}") String user;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
