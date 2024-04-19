package com.hzy.base.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestJson {

    public static void main(String[] args) {
        String sss = "{\"name\":\"test\",\"value\":88.88}";
        DoubleDemo demo = JSON.parseObject(sss, DoubleDemo.class);
//        demo.setName("test");
        demo.setValue(demo.getValue()*100.0);


        System.out.println(JSON.toJSONString(demo));
        System.out.println(JSONObject.toJSONString(demo));
    }

}
