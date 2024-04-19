package com.hzy.base.integer;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1;
        Integer aa = new Integer(1000);
        Integer bb = new Integer(1);
        System.out.println(a == aa);
        System.out.println(b == bb);
        Integer bb2 = new Integer(1);
        System.out.println(bb == bb2);
        Integer bb3 = 1;
        System.out.println(b == bb3);
        Integer aa2 = 1000;
        System.out.println(a == aa2);
        System.out.println("aa2.equals(1000) = " + aa2.equals(1000));

        User sysUser = new User();
        sysUser.setName("test");
        Long aLong = Long.valueOf(sysUser.getId() == null ? 0 : sysUser.getId());
        System.out.println(aLong);
        System.out.println(new Integer(1).equals("1"));

        System.out.println("aa2.equals(null)" + aa2.equals(null));
        Integer x = new Integer(10);
        Integer y = null;
        if (x.equals(y)) {
            System.out.println("a and b are equal");
        } else {
            System.out.println("a and b are not equal");
        }
        System.out.println("1".equals(null));
        Map<Integer, String> map = new HashMap<>();
        map.put(new Integer(1111), "1234");
        System.out.println(map.get(1111L));

        System.out.println(DateUtil.between(DateUtil.parse("2023-09-13 00:00:00"), DateUtil.parse("2023-09-14 23:59:59"), DateUnit.DAY) + 1);
    }

    static class User {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
