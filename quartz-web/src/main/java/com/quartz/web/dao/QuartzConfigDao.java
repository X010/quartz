package com.quartz.web.dao;

import com.quartz.web.model.QuartzConfig;
import org.apache.ibatis.annotations.Delete;
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
public interface QuartzConfigDao {

    /**
     * 添加配置对象
     *
     * @param config
     */
    @Insert("insert into QUARTZ_CONFIG(ckey,cvalue,cflag)values(#{ckey},#{cvalue},#{cflag})")
    public void insertQuartzConfig(QuartzConfig config);

    /**
     * 删除配置项
     *
     * @param id
     */
    @Delete("delete from QUARTZ_CONFIG where id=#{id}")
    public void deleteConfig(@Param("id") long id);

    /**
     * 获取所有配置对象
     *
     * @return
     */
    @Select("select * from QUARTZ_CONFIG")
    public List<QuartzConfig> findQuartzConfig();


    /**
     * 根据CFLAG获取配置对象
     *
     * @param cflag
     * @return
     */
    @Select("select * from QUARTZ_CONFIG where cflag=#{cflag}")
    public List<QuartzConfig> findQuartzConfigByCFlag(@Param("cflag") int cflag);


    /**
     * 根据属性获取唯一的对象
     *
     * @param ckey
     * @param cvalue
     * @param cflag
     * @return
     */
    @Select("select * from QUARTZ_CONFIG where cflag=#{cflag} and ckey=#{ckey} and cvalue=#{cvalue} limit 1")
    public QuartzConfig findQuartzByProperty(@Param("ckey") String ckey, @Param("cvalue") String cvalue, @Param("cflag") int cflag);
}
