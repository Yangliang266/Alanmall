package com.itcrazy.alan.leadtest.designmode.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: mathyoung
 * @description:
 */
public class Jobs1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("wo shi job 11111" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
