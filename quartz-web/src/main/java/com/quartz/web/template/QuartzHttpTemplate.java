package com.quartz.web.template;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quartz.web.service.QuartzService;
import com.quartz.web.util.ClassFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class QuartzHttpTemplate extends QuartzTemplate {


    //URL地址
    private static String HTTP_URL = "httpurl";
    //URL参数
    private static String HTTP_PARAM = "httpparam";


    private final static Logger log = LoggerFactory.getLogger(QuartzHttpTemplate.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getName();
        if (!Strings.isNullOrEmpty(jobName)) {
            QuartzService quartzService = ClassFactory.getBean(QuartzService.class);
            //根据JobName获取参数
            log.info("execute jobname:" + jobName);

        }
    }


    @Override
    public List<String> getParamName() {
        List<String> params = Lists.newArrayList();
        params.add(HTTP_URL);
        params.add(HTTP_PARAM);
        return params;
    }
}
