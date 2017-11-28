package com.cloudTest.base.bean;

import java.util.List;

/**
 * Created by oneapm on 2017/11/28.
 */
public class BaseConfig {


    private String id;
    private String pid;
    private String name;
    private boolean enable;
    private int index;
    private int depth;
    private String clazz;
    private List<BaseConfig> children;

    public List<BaseConfig> getChildren() {
        return children;
    }

    public void setChildren(List<BaseConfig> children) {
        this.children = children;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
