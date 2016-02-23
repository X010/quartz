/* 
 * Copyright 2005 - 2009 Terracotta, Inc. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package org.quartz.examples.example12;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * This example is a client program that will remotely 
 * talk to the scheduler to schedule a job.   In this 
 * example, we will need to use the JDBC Job Store.  The 
 * client will connect to the JDBC Job Store remotely to 
 * schedule the job.
 * 
 * @author James House, Bill Kratzer
 */
public class RemoteClientExample {

    public void run() throws Exception {

        Log log = LogFactory.getLog(RemoteClientExample.class);

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // define the job and ask it to run
        JobDetail job = 
            new JobDetail("remotelyAddedJob", "default", SimpleJob.class);
        JobDataMap map = new JobDataMap();
        map.put("msg", "Your remotely added job has executed!");
        job.setJobDataMap(map);
        CronTrigger trigger = new CronTrigger(
                "remotelyAddedTrigger", "default",
                "remotelyAddedJob", "default", 
                new Date(), 
                null, 
                "/5 * * ? * *");

        // schedule the job
        sched.scheduleJob(job, trigger);

        log.info("Remote job scheduled.");
    }

    public static void main(String[] args) throws Exception {

        RemoteClientExample example = new RemoteClientExample();
        example.run();
    }

}