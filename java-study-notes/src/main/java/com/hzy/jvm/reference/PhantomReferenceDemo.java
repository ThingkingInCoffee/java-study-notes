package com.hzy.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用DEMO
 * 虚引用只能配合引用队列使用，get方法无法获取值
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {

        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        // 无法想软弱引用那样直接使用引用对象构造函数，需配合队列使用
        PhantomReference<Object> reference = new PhantomReference<>(o1, queue);
        System.out.println("虚引用使用get返回值为null");
        System.out.println(reference.get());
        o1 = null;
        System.gc();
        System.out.println(reference.get());
        System.out.println(queue.poll());

    }

}
