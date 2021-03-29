package com.hzy.structure.linear.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        int getCapMulti2 = tableSizeFor(113);
        System.out.println(getCapMulti2);
    }

    /**
     * 取相近的2的幂
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Test
    public void testPutMapEntries() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test");
        String s = map.get("test");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " ======= " + entry.getValue());
        }
        Map<String, String> mapNew = new HashMap<>(map);
        System.out.println(mapNew);
    }

    @Test
    public void testGetHash() {
        int key = 1423412234;
        int hash = testGetHash(key);
        int i = (16 - 1) & hash;
        System.out.println(i);
    }




    public int testGetHash(Integer key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
