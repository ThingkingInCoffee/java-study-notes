package com.hzy.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱引用DEMO
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Integer ref = new Integer(1);
        ReferenceQueue<Integer> queue = new ReferenceQueue<>();
        WeakReference<Integer> weakReference = new WeakReference<>(ref, queue);
        System.out.println(ref);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

        System.out.println("=========ref置空，GC==========");
        ref = null;
        System.gc();
        System.out.println("=========GC结束==========");
        System.out.println(ref);
        System.out.println(weakReference.get());
        System.out.println(queue.poll());

    }

}
