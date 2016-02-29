package com.quartz.web.model;

import java.util.List;

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
 * WEB管理的JOB
 */
public class QuartzWebJob extends BaseModel {

    /**
     * JOB名称
     */
    private String jobName;

    /**
     * 组名
     */
    private String jobGroupName;

    /**
     * 触发器名
     */
    private String triggerName;


    /**
     * 触发器组名
     */
    private String triggerGroupName;

    /**
     * 任务
     */
    private Class cls;

    private String clsStr;

    /**
     * Cron时间表达式
     */
    private String time;

    /**
     * JOB参数
     */
    private List<QuartzParam> quartzParamList;

    public String getClsStr() {
        return clsStr;
    }

    public void setClsStr(String clsStr) {
        this.clsStr = clsStr;
    }

    public List<QuartzParam> getQuartzParamList() {
        return quartzParamList;
    }

    public void setQuartzParamList(List<QuartzParam> quartzParamList) {
        this.quartzParamList = quartzParamList;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
