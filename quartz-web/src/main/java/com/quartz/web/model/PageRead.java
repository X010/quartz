package com.quartz.web.model;

import com.quartz.web.util.CONST;

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
public class PageRead<T> {
    /**
     * 条数
     */
    private int rows;

    /**
     * 页数
     */
    private int pages;

    /**
     * 数据
     */
    private List<T> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPages() {
        if (rows % CONST.PAGE_DEFAULT_SIZE == 0) {
            return rows / CONST.PAGE_DEFAULT_SIZE;
        } else {
            return (rows / CONST.PAGE_DEFAULT_SIZE + 1);
        }
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
