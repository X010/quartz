package com.quartz.web.dao;

import com.quartz.web.model.QuartzParam;
import org.apache.ibatis.annotations.Insert;
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
public interface QuartzParamDao {

    /**
     * 保存数据
     *
     * @param quartzParam
     */
    @Insert("insert into QUARTZ_PARAM(jobname,paraname,paravalue)values(#{jobname},#{paraname},#{paravalue})")
    public void insertQuartzParam(QuartzParam quartzParam);

    /**
     * 根据JOBName读取QuartzParam
     *
     * @param jobname
     * @return
     */
    @Select("select * from QUARTZ_PARAM where jobname=#{jobname}")
    public List<QuartzParam> findQuartzParam(@Param("jobname") String jobname);

    /**
     * 删除JobName数据
     *
     * @param jobname
     */
    @Select("delete from  QUARTZ_PARAM where jobname=#{jobname}")
    public void deleteQuartzByJobName(@Param("jobname") String jobname);
}
