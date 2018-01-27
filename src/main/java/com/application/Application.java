package com.application;

import com.entity.CheckStatus;
import com.repository.CheckObjectRepository;
import com.repository.CheckStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com"})
@EntityScan({"com.entity"})
@EnableAutoConfiguration
@EnableScheduling
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private CheckObjectRepository checkObjectRepository;
    private CheckStatusRepository checkStatusRepository;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        checkObjectRepository = new CheckObjectRepository(jdbcTemplate);
        checkStatusRepository = new CheckStatusRepository(jdbcTemplate);
        log.info("Trying to gather statistics on CHECK_OBJECT table...");
        CheckStatus checkStatus = checkObjectRepository.getStatistics();
        log.info("Trying to update CHECK_STATUS table...");
        checkStatusRepository.addStatus(checkStatus);
    }


}
