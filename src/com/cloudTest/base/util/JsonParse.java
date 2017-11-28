package com.cloudTest.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloudTest.base.bean.BaseConfig;
import com.cloudTest.base.bean.HttpAction;
import com.cloudTest.base.bean.HttpPage;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oneapm on 2017/11/28.
 */
public class JsonParse {

    private static Map<String,Class> reg = new HashMap<String, Class>();
    static{
        try {
            reg.put("HttpAction",Class.forName("com.cloudTest.base.bean.HttpAction"));
            reg.put("HttpPage",Class.forName("com.cloudTest.base.bean.HttpPage"));
            reg.put("Transaction",Class.forName("com.cloudTest.base.bean.Transaction"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object jsonStr2Bean(String jsonStr){
        if(StringUtils.isBlank(jsonStr)){
            return null;
        }
        JSONObject json = JSONObject.parseObject(jsonStr);
        return jsonObject2Bean(json);
    }

    public static Object jsonObject2Bean(JSONObject jsonObject){
        return JSON.toJavaObject(jsonObject,reg.get(jsonObject.getString("clazz")));
    }
    public static String javaObj2JsonStr(Object obj){
        return JSONObject.toJSON(obj).toString();
    }

    public static List<Object> jsonArray2Bean(String jsonStr){
        if(StringUtils.isBlank(jsonStr)){
            return null;
        }
        JSONArray array = JSON.parseArray(jsonStr);
        List<Object> list = new ArrayList<Object>(array.size());
        for(int i = 0,size=array.size();i<size;i++){
            list.add(jsonObject2Bean(array.getJSONObject(i)));
        }
        return list;
    }

    public static void main(String[] args) {

        HttpPage page = new HttpPage();
        page.setId("1");
        page.setPid("2");
        page.setDepth(1);
        page.setEnable(false);
        page.setIndex(1);
        page.setName("this is page");
        page.setClazz("HttpPage");


        HttpAction action = new HttpAction();
        List<BaseConfig> list = new ArrayList<BaseConfig>();
        list.add(action);
        page.setChildren(list);


        String json = javaObj2JsonStr(page);
        System.out.println(json);
        HttpPage page2 = (HttpPage)jsonStr2Bean(json);
        System.out.println(page2.getName());
        System.out.println(page2.getChildren().size());
    }


}
