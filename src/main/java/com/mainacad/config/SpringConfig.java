package com.mainacad.config;

import com.mainacad.dao.ItemDAO;
import com.mainacad.dao.UserDAO;
import com.mainacad.dao.connection.H2Factory;
import com.mainacad.dao.connection.PostgresFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SpringConfig {

    @Bean
    @Profile("test")
    public H2Factory getH2Factory(){
        return new H2Factory();
    }

    @Bean
    @Profile("dev")
    public PostgresFactory getPostgresFactory(){
        return new PostgresFactory();
    }

    @Bean
    public UserDAO getUserDAO(){
        return new UserDAO();
    }

    @Bean
    public ItemDAO getItemDAO(){
        return new ItemDAO();
    }
}
