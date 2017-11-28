package com.cloudTest.base.executor;

import com.cloudTest.base.bean.BaseConfig;

import java.util.List;

/**
 * Created by oneapm on 2017/11/28.
 */
public class CloudExecutor implements Runnable{

    private List<BaseConfig> scripts;
    private String scriptId;
    private long endTime;


    public void run() {
        for(int i = 0,size = scripts.size();i<size;i++){
            BaseConfig baseConfig = scripts.get(i);
        }
    }

    public List<BaseConfig> getScripts() {
        return scripts;
    }

    public void setScripts(List<BaseConfig> scripts) {
        this.scripts = scripts;
    }

    public String getScriptId() {
        return scriptId;
    }

    public void setScriptId(String scriptId) {
        this.scriptId = scriptId;
    }


}
