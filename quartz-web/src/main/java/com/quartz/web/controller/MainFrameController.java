package com.quartz.web.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.quartz.web.model.QuartzConfig;
import com.quartz.web.model.QuartzParam;
import com.quartz.web.model.QuartzWebJob;
import com.quartz.web.service.QuartzService;
import com.quartz.web.template.QuartzTemplate;
import com.quartz.web.util.CONST;
import com.quartz.web.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Controller
@RequestMapping(value = "/")
public class MainFrameController {

    @Autowired
    private QuartzService quartzService;

    /**
     * 登陆
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "login.action")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
        model.setViewName("login");
        return model;
    }


    /**
     * 任务管理
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "taskm.action")
    public ModelAndView taskm(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {

        model.setViewName("taskm");
        return model;
    }

    /**
     * 任务添加
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "taska.action")
    public ModelAndView taska(HttpServletRequest request, HttpServletResponse response
            , ModelAndView model) {
        if (CONST.HTTP_METHOD_POST.equals(request.getMethod())) {
            //获取参数保存数据
            String name = RequestUtil.getString(request, "name", null);
            String jobgroup = RequestUtil.getString(request, "jobgroup", null);
            String tiggergroup = RequestUtil.getString(request, "tiggergroup", null);
            String classgroup = RequestUtil.getString(request, "classgroup", null);
            String cron = RequestUtil.getString(request, "cron", null);
            String param = RequestUtil.getString(request, "param", null);

            //获取参数


            if (!Strings.isNullOrEmpty(name) && !Strings.isNullOrEmpty(cron) && !Strings.isNullOrEmpty(param)) {
                try {
                    QuartzWebJob quartzWebJob = new QuartzWebJob();
                    quartzWebJob.setJobName(name);
                    quartzWebJob.setJobGroupName(jobgroup);
                    quartzWebJob.setTriggerName(name);
                    quartzWebJob.setTriggerGroupName(tiggergroup);
                    //quartzWebJob.setCls();
                    Class jobClass = Class.forName(classgroup);
                    quartzWebJob.setCls(jobClass);
                    quartzWebJob.setTime(cron);

                    Object jobInstance = jobClass.newInstance();
                    if (jobInstance instanceof QuartzTemplate) {
                        QuartzTemplate quartzTemplate = (QuartzTemplate) jobInstance;
                        List<String> paras = quartzTemplate.getParamName();
                        if (paras != null) {
                            List<QuartzParam> quartzParams = Lists.newArrayList();
                            for (String para : paras) {
                                String paraValue = RequestUtil.getString(request, para, null);
                                if (!Strings.isNullOrEmpty(paraValue)) {
                                    QuartzParam quartzParam = new QuartzParam();
                                    quartzParam.setJobname(name);
                                    quartzParam.setParaname(para);
                                    quartzParam.setParavalue(paraValue);
                                    quartzParams.add(quartzParam);
                                }
                            }
                            quartzWebJob.setQuartzParamList(quartzParams);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //保存JOB


            }
        }
        //获取配置项
        List<QuartzConfig> jobGroup = this.quartzService.getQuartzConfigByCFlag(CONST.CONFIG_TYPE_JOB);
        List<QuartzConfig> tiggerGroup = this.quartzService.getQuartzConfigByCFlag(CONST.CONFIG_TYPE_TIGGER);
        List<QuartzConfig> classGroup = this.quartzService.getQuartzConfigByCFlag(CONST.CONFIG_TYPE_CLASS);


        if (jobGroup != null) {
            model.addObject("jobs", jobGroup);
        }

        if (tiggerGroup != null) {
            model.addObject("tiggers", tiggerGroup);
        }

        if (classGroup != null) {
            model.addObject("classs", classGroup);
        }

        model.setViewName("taska");
        return model;
    }

    /**
     * 系统配置
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "config.action")
    public ModelAndView config(HttpServletRequest request, HttpServletResponse response
            , ModelAndView model) {
        if (CONST.HTTP_METHOD_POST.equals(request.getMethod())) {
            int cflag = RequestUtil.getInt(request, "cflag", 0);
            String ckey = RequestUtil.getString(request, "ckey", null);
            String cvalue = RequestUtil.getString(request, "cvalue", null);

            if (cflag > 0 && !Strings.isNullOrEmpty(ckey) && !Strings.isNullOrEmpty(cvalue)) {
                QuartzConfig quartzConfig = new QuartzConfig();
                quartzConfig.setCflag(cflag);
                quartzConfig.setCkey(ckey);
                quartzConfig.setCvalue(cvalue);
                this.quartzService.saveQuartzConfig(quartzConfig);
            }
        }

        //读取系统配置项
        List<QuartzConfig> quartzConfigList = this.quartzService.getQuartzConfig();

        if (quartzConfigList != null) {
            model.addObject("data", quartzConfigList);
        }
        model.setViewName("config");
        return model;
    }
}
