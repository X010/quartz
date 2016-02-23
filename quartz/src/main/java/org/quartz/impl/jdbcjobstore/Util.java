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


package org.quartz.impl.jdbcjobstore;

import java.text.MessageFormat;

/**
 * <p>
 * This class contains utility functions for use in all delegate classes.
 * </p>
 * 
 * @author <a href="mailto:jeff@binaryfeed.org">Jeffrey Wescott</a>
 */
public final class Util {

    /**
     * Private constructor because this is a pure utility class.
     */
    private Util() {
    }
    
    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 
     * Interface.
     * 
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * <p>
     * Replace the table prefix in a query by replacing any occurrences of
     * "{0}" with the table prefix.
     * </p>
     * 
     * @param query
     *          the unsubstitued query
     * @param tablePrefix
     *          the table prefix
     * @return the query, with proper table prefix substituted
     */
    public static String rtp(String query, String tablePrefix) {
        return MessageFormat.format(query, new Object[]{tablePrefix});
    }

    /**
     * <p>
     * Obtain a unique key for a given job.
     * </p>
     * 
     * @param jobName
     *          the job name
     * @param groupName
     *          the group containing the job
     * @return a unique <code>String</code> key
     */
    static String getJobNameKey(String jobName, String groupName) {
        return (groupName + "_$x$x$_" + jobName).intern();
    }

    /**
     * <p>
     * Obtain a unique key for a given trigger.
     * </p>
     * 
     * @param triggerName
     *          the trigger name
     * @param groupName
     *          the group containing the trigger
     * @return a unique <code>String</code> key
     */
    static String getTriggerNameKey(String triggerName, String groupName) {
        return (groupName + "_$x$x$_" + triggerName).intern();
    }
}

// EOF
