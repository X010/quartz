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

package org.quartz.examples.example5;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * Demonstrates the behavior of <code>StatefulJob</code>s, as well as how
 * misfire instructions affect the firings of triggers of <code>StatefulJob</code>
 * s - when the jobs take longer to execute that the frequency of the trigger's
 * repitition.
 * 
 * <p>
 * While the example is running, you should note that there are two triggers
 * with identical schedules, firing identical jobs. The triggers "want" to fire
 * every 3 seconds, but the jobs take 10 seconds to execute. Therefore, by the
 * time the jobs complete their execution, the triggers have already "misfired"
 * (unless the scheduler's "misfire threshold" has been set to more than 7
 * seconds). You should see that one of the jobs has its misfire instruction
 * set to <code>SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT</code>,
 * which causes it to fire immediately, when the misfire is detected. The other
 * trigger uses the default "smart policy" misfire instruction, which causes
 * the trigger to advance to its next fire time (skipping those that it has
 * missed) - so that it does not refire immediately, but rather at the next
 * scheduled time.
 * </p>
 * 
 * @author <a href="mailto:bonhamcm@thirdeyeconsulting.com">Chris Bonham</a>
 */
public class MisfireExample {

    
    public void run() throws Exception {
        Log log = LogFactory.getLog(MisfireExample.class);

        log.info("------- Initializing -------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        log.info("------- Initialization Complete -----------");

        log.info("------- Scheduling Jobs -----------");

        // jobs can be scheduled before start() has been called

        // get a "nice round" time a few seconds in the future...
        long ts = TriggerUtils.getNextGivenSecondDate(null, 15).getTime();

        // statefulJob1 will run every three seconds
        // (but it will delay for ten seconds)
        JobDetail job = new JobDetail("statefulJob1", "group1",
                StatefulDumbJob.class);
        job.getJobDataMap().put(MisfireJob.EXECUTION_DELAY, 10000L);
        SimpleTrigger trigger = new SimpleTrigger("trigger1", "group1", 
                new Date(ts), null, 
                SimpleTrigger.REPEAT_INDEFINITELY, 3000L);
        Date ft = sched.scheduleJob(job, trigger);
        log.info(job.getFullName() +
                " will run at: " + ft +  
                " and repeat: " + trigger.getRepeatCount() + 
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // statefulJob2 will run every three seconds
        // (but it will delay for ten seconds)
        job = new JobDetail("statefulJob2", "group1", StatefulDumbJob.class);
        job.getJobDataMap().put(MisfireJob.EXECUTION_DELAY, 10000L);
        trigger = new SimpleTrigger("trigger2", "group1", 
                new Date(ts), null,
                SimpleTrigger.REPEAT_INDEFINITELY, 3000L);
        trigger
            .setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT);
        ft = sched.scheduleJob(job, trigger);
        log.info(job.getFullName() +
                " will run at: " + ft +  
                " and repeat: " + trigger.getRepeatCount() + 
                " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        log.info("------- Starting Scheduler ----------------");

        // jobs don't start firing until start() has been called...
        sched.start();

        log.info("------- Started Scheduler -----------------");
        
        try {
            // sleep for ten minutes for triggers to file....
            Thread.sleep(600L * 1000L); 
        } catch (Exception e) {
        }

        log.info("------- Shutting Down ---------------------");

        sched.shutdown(true);

        log.info("------- Shutdown Complete -----------------");

        SchedulerMetaData metaData = sched.getMetaData();
        log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }



    public static void main(String[] args) throws Exception {

        MisfireExample example = new MisfireExample();
        example.run();
    }

}