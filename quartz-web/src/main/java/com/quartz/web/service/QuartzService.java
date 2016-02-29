package com.quartz.web.service;

import com.quartz.web.model.PageInfo;
import com.quartz.web.model.PageRead;
import com.quartz.web.model.QuartzConfig;
import com.quartz.web.model.QuartzWebJob;

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
public interface QuartzService {

    /**
     * 保存QuartzConfig对象
     *
     * @param quartzConfig
     */
    public void saveQuartzConfig(QuartzConfig quartzConfig);

    /**
     * 保存QuartzWebJob对像
     *
     * @param quartzWebJob
     */
    public void saveQuartzWebJob(QuartzWebJob quartzWebJob);

    /**
     * 删除QuartzWebJob对象
     *
     * @param jobName
     */
    public void deletQuartzWebJob(String jobName);


    /**
     * 获取系统配置项
     *
     * @return
     */
    public List<QuartzConfig> getQuartzConfig();


    /**
     * 获取QuartzConfig
     *
     * @param cflag
     * @return
     */
    public List<QuartzConfig> getQuartzConfigByCFlag(int cflag);


    /**
     * 分页读取QuartzWebJob
     *
     * @return
     */
    public PageRead<QuartzWebJob> findQuartzWebJob(PageInfo pageInfo);

    /**
     * 删除配置项
     *
     * @param id
     */
    public void deleteConfig(long id);


    /**
     * 根据用户名与密码获取对象
     * @param username
     * @param password
     * @return
     */
    public QuartzConfig findUsernameAndPassword(String username,String password);
}
