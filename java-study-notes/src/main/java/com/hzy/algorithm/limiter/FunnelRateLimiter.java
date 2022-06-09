package com.hzy.algorithm.limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * 漏斗限流
 *
 * @author hzy
 * @description: FunnelRateLimiter.java
 * @date 2022/6/9 11:07
 */
public class FunnelRateLimiter {

    static Map<String, Funnel> container = new HashMap<>();

    public static boolean addActionCheck(String key, int capacity, int rate) {
        Funnel funnel = container.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, rate);
            container.put(key, funnel);
        }
        return funnel.addThing(1);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            boolean b = addActionCheck("test", 5, 2);
            System.out.println(b);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 漏斗
     */
    static class Funnel {
        int capacity; // 容量
        int leakingRate; // 流出时间戳
        int leftQuote; // 剩余容量
        long leakingTs; // 最后流出时间戳

        public Funnel(int capacity, int leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuote = capacity;
            this.leakingTs = System.currentTimeMillis();
        }

        /**
         * 计算剩余空间
         */
        void makeSpace() {
            long nowTs = System.currentTimeMillis();
            long diffTs = nowTs - leakingTs;
            int diffQuote = (int) (leakingRate * (diffTs / 1000)); // 过去一段时间之内流出数量
            if (diffQuote < 0) { // 超出int范围
                this.leftQuote = capacity;
                this.leakingTs = nowTs;
                return;
            }
            if (diffQuote < 1) { // 最小单位 1 ，小于 1 忽略
                return;
            }
            this.leakingTs = nowTs;
            this.leftQuote += diffQuote; // 将过去一段时间流出的空间加给容量
            if (leftQuote > capacity) {
                this.leftQuote = capacity;
            }
        }

        boolean addThing(int addQuota) {
            makeSpace();
            if (this.leftQuote > addQuota) {
                this.leftQuote -= addQuota;
                return true;
            }
            return false;
        }
    }

}
