
/* 
 * Copyright 2001-2009 Terracotta, Inc. 
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

package org.quartz.core;

import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;

/**
 * <p>
 * Responsible for creating the instances of <code>{@link JobRunShell}</code>
 * to be used within the <class>{@link QuartzScheduler}</code> instance.
 * </p>
 * 
 * <p>
 * Although this interface looks a lot like an 'object pool', implementations
 * do not have to support the re-use of instances. If an implementation does
 * not wish to pool instances, then the <code>borrowJobRunShell()</code>
 * method would simply create a new instance, and the <code>returnJobRunShell
 * </code> method would do nothing.
 * </p>
 * 
 * @author James House
 */
public interface JobRunShellFactory {

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Interface.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * <p>
     * Initialize the factory, providing a handle to the <code>Scheduler</code>
     * that should be made available within the <code>JobRunShell</code> and
     * the <code>JobExecutionCOntext</code> s within it, and a handle to the
     * <code>SchedulingContext</code> that the shell will use in its own
     * operations with the <code>JobStore</code>.
     * </p>
     */
    void initialize(Scheduler scheduler, SchedulingContext schedCtxt)
        throws SchedulerConfigException;

    /**
     * <p>
     * Called by the <code>{@link org.quartz.core.QuartzSchedulerThread}</code>
     * to obtain instances of <code>{@link JobRunShell}</code>.
     * </p>
     */
    JobRunShell borrowJobRunShell() throws SchedulerException;

    /**
     * <p>
     * Called by the <code>{@link org.quartz.core.QuartzSchedulerThread}</code>
     * to return instances of <code>{@link JobRunShell}</code>.
     * </p>
     */
    void returnJobRunShell(JobRunShell jobRunShell);

}