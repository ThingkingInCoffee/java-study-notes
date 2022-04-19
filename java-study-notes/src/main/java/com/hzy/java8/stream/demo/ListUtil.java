package com.hzy.java8.stream.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxt
 * 2021/11/16 12:54
 * @version 1.0
 */
public class ListUtil {
    /**
     * 将一组数据平均分成n组
     *
     * @param source 要分组的数据源
     * @param n      平均分成n组
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }
    /**
     * 将一组数据固定分组，每组n个元素
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> fixedGrouping(List<T> source, int n) {

        if (null == source || source.size() == 0 || n <= 0){
            return null;}
        List<List<T>> result = new ArrayList<List<T>>();

        int sourceSize = source.size();
        int size = (source.size() / n) + 1;
        for (int i = 0; i < size; i++) {
            List<T> subset = new ArrayList<T>();
            for (int j = i * n; j < (i + 1) * n; j++) {
                if (j < sourceSize) {
                    subset.add(source.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
    /**
     * 将一组数据固定分组，每组n个元素
     *
     * @param source 要分组的数据源
     * @param n      每组n个元素
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> fixedGrouping2(List<T> source, int n) {

        if (null == source || source.size() == 0 || n <= 0){
            return null;}
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;
        int size = (source.size() / n);
        for (int i = 0; i < size; i++) {
            List<T> subset = null;
            subset = source.subList(i * n, (i + 1) * n);
            result.add(subset);
        }
        if (remainder > 0) {
            List<T> subset = null;
            subset = source.subList(size * n, size * n + remainder);
            result.add(subset);
        }
        return result;
    }
    /**
     * 平台货单商品list分组结果
     * @author  wxt
     * date 2021/11/16 14:40
     * @param source
     * @return
     */
    public static <T> List<List<T>> stockListGroup(List<T> source) {
      return   fixedGrouping2(source,10);
    }


    public static void main(String[] args) {

        List integers=new ArrayList<>();

        integers.add(1);

        integers.add(2);

        integers.add(3);

        integers.add(4);

        integers.add(5);

        List lists=averageAssign(integers, 2);
        System.out.println(lists);
        long l = System.currentTimeMillis();
        List lists2=fixedGrouping(integers, 2);
        long l2 = System.currentTimeMillis();
        System.out.println(lists2);
        System.out.println(l2-l);
        long l3 = System.currentTimeMillis();
        List lists3=fixedGrouping2(integers, 2);
        long l4 = System.currentTimeMillis();
        System.out.println(l4-l3);
        System.out.println(lists3);

    }
}
