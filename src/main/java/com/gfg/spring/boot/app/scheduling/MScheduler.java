package com.gfg.spring.boot.app.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MScheduler {

    @Scheduled(cron = "0 * * * * *")
    public void scheduleTask() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd MM yyyy HH:mm:ss.SSS");
        System.out.println("Scheduled timer - Job running at: " + fmt.format(new Date()));
    }
}
