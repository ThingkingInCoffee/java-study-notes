package com.hzy.base.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap 弱引用Map，key引用对象方式为弱引用，当key不再正常使用时，例如被置空，那么该key-value会被从map中删除
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        testPlainHashMap();

        System.out.println("----------------------");

        testWeakHashMap();
    }

    /**
     * 普通hashmap
     */
    public static void testPlainHashMap() {
        Map<Integer, String> map = new HashMap<>();
        Integer key = new Integer(2);
        String value = "test";
        map.put(key, value);
        System.out.println("HashMap存入kv值");
        System.out.println("HashMap 打印" + map);

        System.out.println();

        key = null;
        System.out.println("key 被置空 null");
        System.out.println("HashMap 打印" + map);

        System.gc();
        System.out.println("调用GC");
        System.out.println("HashMap 打印" + map);
    }

    /**
     * 普通hashmap
     */
    public static void testWeakHashMap() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "test";
        map.put(key, value);
        System.out.println("WeakHashMap存入kv值");
        System.out.println("WeakHashMap 打印" + map);

        System.out.println();

        key = null;
        System.out.println("key 被置空 null");
        System.out.println("WeakHashMap 打印" + map);

        System.gc();
        System.out.println("调用GC");
        System.out.println("WeakHashMap 打印" + map);
    }

}
