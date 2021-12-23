package com.hzy.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @author hzy
 * @description: IdUtilDemo.java
 * @date 2021/12/15 16:54
 */
public class IdUtilDemo {

    public static void main(String[] args) {
        long workerId = 1L;
        long dataCenterId = 1L;
        System.out.println(IdUtil.createSnowflake(workerId, dataCenterId));;
        System.out.println(IdUtil.getSnowflake(workerId, dataCenterId));;
        System.out.println(IdUtil.fastSimpleUUID());;
        System.out.println(IdUtil.fastUUID());;
        System.out.println(IdUtil.objectId());;
        System.out.println(IdUtil.randomUUID());;
        IdUtil.simpleUUID();
    }

}
