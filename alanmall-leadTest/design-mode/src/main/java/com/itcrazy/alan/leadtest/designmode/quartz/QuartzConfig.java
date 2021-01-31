package com.itcrazy.alan.leadtest.designmode.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description:
 */
@Component
public class QuartzConfig {
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    public void scheduleCron(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(Jobs1.class)
                .withIdentity("job1", "group1")
                .build();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder)
                .build();

        scheduler.scheduleJob(jobDetail,cronTrigger);
    }

    public void scheduleSimple(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder
                .newJob(Jobs1.class)
                .withIdentity("job1", "group1")
                .build();

        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .startAt(new Date())
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5)
                                .withRepeatCount(3))//重复执行的次数，因为加入任务的时候马上执行了，所以不需要重复，否则会多一次。
                .build();

        scheduler.scheduleJob(jobDetail,simpleTrigger);
    }

    public void scheduleJobsCron() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleCron(scheduler);
    }

    public void scheduleJobsSimple() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleSimple(scheduler);
    }


}
