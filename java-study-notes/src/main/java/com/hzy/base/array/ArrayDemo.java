package com.hzy.base.array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class ArrayDemo {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        String jsonString = JSON.toJSONString(a);
        JSONArray jsonArray = JSON.parseArray(jsonString);
        if (jsonArray.size() > 0) {
            int[] b = new int[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                b[i] = jsonArray.getInteger(i);

            }
        }

        System.out.println(50000/2000+1);
        System.out.println(50000/2000);
        System.out.println(52000/2000);
    }

}
