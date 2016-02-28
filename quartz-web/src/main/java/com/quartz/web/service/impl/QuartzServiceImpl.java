package com.quartz.web.service.impl;

import com.google.common.base.Preconditions;
import com.quartz.web.dao.QuartzConfigDao;
import com.quartz.web.dao.QuartzParamDao;
import com.quartz.web.model.PageInfo;
import com.quartz.web.model.QuartzConfig;
import com.quartz.web.model.QuartzParam;
import com.quartz.web.model.QuartzWebJob;
import com.quartz.web.service.QuartzService;
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

    private static void QuartzServiceImpl() {
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
    public List<QuartzConfig> getQuartzConfig() {
        return this.quartzConfigDao.findQuartzConfig();
    }

    @Override
    public List<QuartzConfig> getQuartzConfigByCFlag(int cflag) {
        return this.quartzConfigDao.findQuartzConfigByCFlag(cflag);
    }

    @Override
    public List<QuartzWebJob> findQuartzWebJob(PageInfo pageInfo) {
        Preconditions.checkNotNull(pageInfo);


        return null;
    }
}
