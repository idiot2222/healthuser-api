package com.pps.config;

import com.pps.adapter.UserJpaAdapter;
import com.pps.ports.incoming.UserServicePort;
import com.pps.ports.outgoing.UserPersistencePort;
import com.pps.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserServicePort userServicePort() {
        return new UserServiceImpl(userPersistencePort());
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserJpaAdapter();
    }

}
