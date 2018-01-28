package com.verification.service;

import com.verification.entity.CheckStatus;
import com.verification.repository.CheckObjectRepository;
import com.verification.repository.CheckStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    private static final Logger log = LoggerFactory.getLogger(CheckService.class);

    private final CheckObjectRepository checkObjectRepository;
    private final CheckStatusRepository checkStatusRepository;

    public CheckService(CheckObjectRepository checkObjectRepository, CheckStatusRepository checkStatusRepository) {
        this.checkObjectRepository = checkObjectRepository;
        this.checkStatusRepository = checkStatusRepository;
    }

    @Scheduled(cron = "0 0 23 * * MON-FRI")
    public void makeChecks() {
        log.info("Trying to gather statistics on CHECK_OBJECT table...");
        CheckStatus checkStatus = checkObjectRepository.getStatistics();
        log.info("Trying to update CHECK_STATUS table...");
        checkStatusRepository.addStatus(checkStatus);
    }
}
