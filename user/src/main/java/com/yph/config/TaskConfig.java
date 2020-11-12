package com.yph.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author Agu
 */
@Configuration
public class TaskConfig {


    @Scheduled(cron = "0 0 0 * * ?")
    private void delRedisKeyTimer() {

    }


}
