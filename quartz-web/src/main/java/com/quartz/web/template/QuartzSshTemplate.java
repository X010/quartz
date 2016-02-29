package com.quartz.web.template;

import com.google.common.collect.Lists;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
public class QuartzSshTemplate extends QuartzTemplate {

    private final static String host = "host";
    private final static String post = "post";
    private final static String shell = "shell";
    private final static String username = "username";
    private final static String password = "password";

    @Override
    public List<String> getParamName() {
        List<String> params = Lists.newArrayList();
        params.add(host);
        params.add(post);
        params.add(shell);
        params.add(username);
        params.add(password);
        return params;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
