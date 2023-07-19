package com.imajity.servicedesk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.imajity.servicedesk.TaskRepository;

@Configuration
class LoadDatabase {
    
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository repository) {

        return args -> {
            logger.info("Preload" + repository.save(new Task("Test task 1", "task 1")));
            logger.info("Preload" + repository.save(new Task("Test task 2", "task 2")));
        };
    }
}
