package com.yph.config;

import com.yph.modules.user.execute.LifeSourceExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author Agu
 */
@Configuration
public class TaskConfig {


    @Autowired
    LifeSourceExecute lifeSourceExecute;

    @Scheduled(cron = "0 0 0 * * ?")
    private void delRedisKeyTimer() {
        System.out.println("定时器");
        lifeSourceExecute.LifeSourceToEnergy();
    }


}
