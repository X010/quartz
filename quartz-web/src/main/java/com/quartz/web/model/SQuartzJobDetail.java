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
public class SQuartzJobDetail {

    private String JOB_NAME;
    private String JOB_GROUP;
    private String DESCRIPTION;
    private String JOB_CLASS_NAME;
    private String IS_DURABLE;
    private String IS_VOLATILE;
    private String IS_STATEFUL;
    private String REQUESTS_RECOVERY;


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

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getJOB_CLASS_NAME() {
        return JOB_CLASS_NAME;
    }

    public void setJOB_CLASS_NAME(String JOB_CLASS_NAME) {
        this.JOB_CLASS_NAME = JOB_CLASS_NAME;
    }

    public String getIS_DURABLE() {
        return IS_DURABLE;
    }

    public void setIS_DURABLE(String IS_DURABLE) {
        this.IS_DURABLE = IS_DURABLE;
    }

    public String getIS_VOLATILE() {
        return IS_VOLATILE;
    }

    public void setIS_VOLATILE(String IS_VOLATILE) {
        this.IS_VOLATILE = IS_VOLATILE;
    }

    public String getIS_STATEFUL() {
        return IS_STATEFUL;
    }

    public void setIS_STATEFUL(String IS_STATEFUL) {
        this.IS_STATEFUL = IS_STATEFUL;
    }

    public String getREQUESTS_RECOVERY() {
        return REQUESTS_RECOVERY;
    }

    public void setREQUESTS_RECOVERY(String REQUESTS_RECOVERY) {
        this.REQUESTS_RECOVERY = REQUESTS_RECOVERY;
    }
}
