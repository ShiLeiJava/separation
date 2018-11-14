package com.leo.separation.config.dbConfig;

/**
 * @Copyright 上海后丽信息科技有限公司
 * Created by Leo_lei on 2018/11/8
 */
public enum  DataSourceType {

    read("read", "从库"),
    write("write", "主库");

    private String type;

    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
