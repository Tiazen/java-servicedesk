package com.tiazen.servicedesk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tiazen.servicedesk.models.Task;
import com.tiazen.servicedesk.repositories.TaskRepository;

@Configuration
class LoadDatabase {
    
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {

        return args -> {
        };
    }
}
