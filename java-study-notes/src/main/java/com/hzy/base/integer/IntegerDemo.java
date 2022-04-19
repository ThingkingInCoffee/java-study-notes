package com.hzy.base.integer;

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
        System.out.println( "aa2.equals(1000) = "+ aa2.equals(1000));

        User sysUser = new User();
        sysUser.setName("test");
        Long aLong = Long.valueOf(sysUser.getId() == null ? 0 : sysUser.getId());
        System.out.println(aLong);
        System.out.println(new Integer(1).equals("1"));

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
