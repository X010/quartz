package com.quartz.web.dao;

import com.quartz.web.model.SQuartzCronTigger;
import com.quartz.web.model.SQuartzJobDetail;
import com.quartz.web.model.SQuartzTiggers;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface QuartzWebJobDao {

    /**
     * 统计JobDetail条数
     *
     * @return
     */
    @Select("select count(1) from QRTZ_JOB_DETAILS")
    public int countJobDetailRows();


    /**
     * 分页读取JobDetail数据
     *
     * @param start
     * @param size
     * @return
     */
    @Select("select * from QRTZ_JOB_DETAILS limit #{start},#{size}")
    public List<SQuartzJobDetail> findSQuartzJobDetailByPage(@Param("start") int start, @Param("size") int size);


    /**
     * 根据Name获取JobDetail
     *
     * @param name
     * @return
     */
    @Select("select * from QRTZ_JOB_DETAILS where JOB_NAME=#{name} limit 1")
    public SQuartzJobDetail findSQuartzDetailByJobName(@Param("name") String name);

    /**
     * 读取JobCronTigger
     *
     * @param name
     * @return
     */
    @Select("select * from QRTZ_CRON_TRIGGERS where TRIGGER_NAME=#{name} limit 1")
    public SQuartzCronTigger findSQuartzCronTiggerByJobName(@Param("name") String name);


    /**
     * 读取TiggerGroup信息
     *
     * @param name
     * @return
     */
    @Select("select * from QRTZ_TRIGGERS where TRIGGER_NAME=#{name} limit 1")
    public SQuartzTiggers findSQuartzTiggersByTiggerName(@Param("name") String name);
}
