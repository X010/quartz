package com.quartz.web.model;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SQuartzTiggers {

    private String TRIGGER_NAME;
    private String TRIGGER_GROUP;
    private String JOB_NAME;
    private String JOB_GROUP;
    private String IS_VOLATILE;
    private String DESCRIPTION;
    private long NEXT_FIRE_TIME;
    private long PREV_FIRE_TIME;
    private int PRIORITY;
    private String TRIGGER_STATE;
    private String TRIGGER_TYPE;
    private long START_TIME;
    private long END_TIME;
    private String CALENDAR_NAME;
    private int MISFIRE_INSTR;


    public String getTRIGGER_NAME() {
        return TRIGGER_NAME;
    }

    public void setTRIGGER_NAME(String TRIGGER_NAME) {
        this.TRIGGER_NAME = TRIGGER_NAME;
    }

    public String getTRIGGER_GROUP() {
        return TRIGGER_GROUP;
    }

    public void setTRIGGER_GROUP(String TRIGGER_GROUP) {
        this.TRIGGER_GROUP = TRIGGER_GROUP;
    }

    public String getJOB_NAME() {
        return JOB_NAME;
    }

    public void setJOB_NAME(String JOB_NAME) {
        this.JOB_NAME = JOB_NAME;
    }

    public String getJOB_GROUP() {
        return JOB_GROUP;
    }

    public void setJOB_GROUP(String JOB_GROUP) {
        this.JOB_GROUP = JOB_GROUP;
    }

    public String getIS_VOLATILE() {
        return IS_VOLATILE;
    }

    public void setIS_VOLATILE(String IS_VOLATILE) {
        this.IS_VOLATILE = IS_VOLATILE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public long getNEXT_FIRE_TIME() {
        return NEXT_FIRE_TIME;
    }

    public void setNEXT_FIRE_TIME(long NEXT_FIRE_TIME) {
        this.NEXT_FIRE_TIME = NEXT_FIRE_TIME;
    }

    public long getPREV_FIRE_TIME() {
        return PREV_FIRE_TIME;
    }

    public void setPREV_FIRE_TIME(long PREV_FIRE_TIME) {
        this.PREV_FIRE_TIME = PREV_FIRE_TIME;
    }

    public int getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(int PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    public String getTRIGGER_STATE() {
        return TRIGGER_STATE;
    }

    public void setTRIGGER_STATE(String TRIGGER_STATE) {
        this.TRIGGER_STATE = TRIGGER_STATE;
    }

    public String getTRIGGER_TYPE() {
        return TRIGGER_TYPE;
    }

    public void setTRIGGER_TYPE(String TRIGGER_TYPE) {
        this.TRIGGER_TYPE = TRIGGER_TYPE;
    }

    public long getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(long START_TIME) {
        this.START_TIME = START_TIME;
    }

    public long getEND_TIME() {
        return END_TIME;
    }

    public void setEND_TIME(long END_TIME) {
        this.END_TIME = END_TIME;
    }

    public String getCALENDAR_NAME() {
        return CALENDAR_NAME;
    }

    public void setCALENDAR_NAME(String CALENDAR_NAME) {
        this.CALENDAR_NAME = CALENDAR_NAME;
    }

    public int getMISFIRE_INSTR() {
        return MISFIRE_INSTR;
    }

    public void setMISFIRE_INSTR(int MISFIRE_INSTR) {
        this.MISFIRE_INSTR = MISFIRE_INSTR;
    }
}
