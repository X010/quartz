package com.quartz.web.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.quartz.web.dao.QuartzConfigDao;
import com.quartz.web.dao.QuartzParamDao;
import com.quartz.web.dao.QuartzWebJobDao;
import com.quartz.web.model.*;
import com.quartz.web.service.QuartzService;
import com.quartz.web.util.CONST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 */
@Service
public class QuartzServiceImpl implements QuartzService {


    @Autowired
    private QuartzConfigDao quartzConfigDao;

    @Autowired
    private QuartzParamDao quartzParamDao;

    @Autowired
    private QuartzWebJobDao quartzWebJobDao;

    static {
        QuartzManager.startJobs();
    }

    @Override
    public void saveQuartzConfig(QuartzConfig quartzConfig) {
        Preconditions.checkNotNull(quartzConfig);

        this.quartzConfigDao.insertQuartzConfig(quartzConfig);
    }

    @Override
    public void saveQuartzWebJob(QuartzWebJob quartzWebJob) {
        Preconditions.checkNotNull(quartzWebJob);
        try {
            List<QuartzParam> quartzParams = quartzWebJob.getQuartzParamList();
            if (quartzParams != null) {
                quartzParams.stream().forEach(quartzParam -> {
                    //保存QuartzParam数据
                    this.quartzParamDao.insertQuartzParam(quartzParam);
                });

                //保存JobManager
                QuartzManager.addJob(quartzWebJob.getJobName(), quartzWebJob.getJobGroupName(), quartzWebJob.getTriggerName()
                        , quartzWebJob.getTriggerGroupName(), quartzWebJob.getCls(), quartzWebJob.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletQuartzWebJob(String jobName) {
        Preconditions.checkNotNull(jobName);
        SQuartzCronTigger sQuartzCronTigger = this.quartzWebJobDao.findSQuartzCronTiggerByJobName(jobName);
        SQuartzJobDetail sQuartzJobDetail = this.quartzWebJobDao.findSQuartzDetailByJobName(jobName);
        if (sQuartzCronTigger != null && sQuartzJobDetail != null) {
            QuartzManager.removeJob(jobName, sQuartzJobDetail.getJOB_GROUP(), sQuartzCronTigger.getTRIGGER_NAME(), sQuartzCronTigger.getTRIGGER_GROUP());
            this.quartzParamDao.deleteQuartzByJobName(jobName);
        }
    }

    @Override
    public List<QuartzConfig> getQuartzConfig() {
        return this.quartzConfigDao.findQuartzConfig();
    }

    @Override
    public List<QuartzConfig> getQuartzConfigByCFlag(int cflag) {
        return this.quartzConfigDao.findQuartzConfigByCFlag(cflag);
    }

    @Override
    public PageRead<QuartzWebJob> findQuartzWebJob(PageInfo pageInfo) {
        Preconditions.checkNotNull(pageInfo);
        //读取Quartz的列表
        PageRead<QuartzWebJob> quartzWebJobPageRead = new PageRead<>();
        int start = (pageInfo.getPage() - 1) * pageInfo.getSize();
        List<SQuartzJobDetail> sQuartzJobDetails = this.quartzWebJobDao.findSQuartzJobDetailByPage(start, pageInfo.getSize());
        if (sQuartzJobDetails != null) {
            final List<QuartzWebJob> quartzWebJobs = Lists.newArrayList();
            sQuartzJobDetails.stream().forEach(sQuartzJobDetail -> {
                QuartzWebJob quartzWebJob = new QuartzWebJob();
                quartzWebJob.setJobName(sQuartzJobDetail.getJOB_NAME());
                quartzWebJob.setJobGroupName(sQuartzJobDetail.getJOB_GROUP());
                quartzWebJob.setClsStr(sQuartzJobDetail.getJOB_CLASS_NAME());

                //根据JobName获取JobTigger
                SQuartzCronTigger sQuartzCronTigger = this.quartzWebJobDao.findSQuartzCronTiggerByJobName(sQuartzJobDetail.getJOB_NAME());
                if (sQuartzCronTigger != null) {
                    quartzWebJob.setTriggerName(sQuartzCronTigger.getTRIGGER_NAME());
                    quartzWebJob.setTriggerGroupName(sQuartzCronTigger.getTRIGGER_GROUP());
                    quartzWebJob.setTime(sQuartzCronTigger.getCRON_EXPRESSION());
                }
                quartzWebJobs.add(quartzWebJob);
            });
            quartzWebJobPageRead.setData(quartzWebJobs);
            quartzWebJobPageRead.setRows(this.quartzWebJobDao.countJobDetailRows());
            return quartzWebJobPageRead;
        }
        return null;
    }

    @Override
    public void deleteConfig(long id) {
        Preconditions.checkNotNull(id > 0);
        this.quartzConfigDao.deleteConfig(id);
    }

    @Override
    public QuartzConfig findUsernameAndPassword(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        return this.quartzConfigDao.findQuartzByProperty(username, password, CONST.CONFIG_TYPE_USER);
    }
}
