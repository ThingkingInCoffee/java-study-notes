package com.hzy.base.list;

import cn.hutool.http.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list = null;
//        System.out.println(list.isEmpty());
        String body = HttpUtil.get("https://api.map.baidu.com/reverse_geocoding/v3/?ak=itqOxtPACAg4yKLUhm8CT3lIlIGubHSW&output=json&coordtype=bd09ll&location=31.831439214392084,119.95631388906942");
        System.out.println(body);
    }
}
