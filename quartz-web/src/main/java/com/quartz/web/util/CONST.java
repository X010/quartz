package com.quartz.web.util;

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
public class CONST {

    /**
     * GET方式
     */
    public static String HTTP_METHOD_GET = "GET";

    /**
     * POST
     */
    public static String HTTP_METHOD_POST = "POST";


    //类型
    public static int CONFIG_TYPE_USER = 1;
    public static int CONFIG_TYPE_JOB = 2;
    public static int CONFIG_TYPE_TIGGER = 3;
    public static int CONFIG_TYPE_CLASS = 4;

    //分页参数
    public static int PAGE_DEFAULT_PAGE = 1;
    public static int PAGE_DEFAULT_SIZE = 20;
}
