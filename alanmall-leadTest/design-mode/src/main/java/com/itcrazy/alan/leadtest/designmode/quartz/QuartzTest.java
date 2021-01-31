package com.itcrazy.alan.leadtest.designmode.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mathyoung CronSchedulerJob
 * @description:
 */
@RestController
@RequestMapping("test")
public class QuartzTest {
    @Autowired
    QuartzConfig scheduleJobs;

//    @Override
//    public void run(String... args) throws Exception {
//        scheduleJobs.scheduleJobs();
//        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
//    }

    @RequestMapping("/quartz")
    public String quartz() throws SchedulerException {
        scheduleJobs.scheduleJobsSimple();
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
        return "success";
    }

}
