package com.hzy.java8.stream.demo;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author hzy
 * @description: TestParalell.java
 * @date 2022/4/19 11:17
 */
public class TestParalell {

    public static List<String> list = Arrays.asList("3511703510023",
            "4421704420131",
            "4421704420131",
            "1031701035112",
            "1031701035112",
            "2471702474170",
            "2471702474170",
            "2471702471375",
            "2471702471375",
            "5301705300002",
            "5301705300002",
            "1991701994039",
            "1991701994039",
            "2311702310692",
            "2311702310692",
            "2471702471040",
            "2471702471040",
            "889532138494",
            "1621701621601",
            "1991701992421",
            "1991701992421",
            "1991701992574",
            "1991701992574",
            "1991701992503",
            "1991701992503",
            "9009653890465",
            "9009653890465",
            "1181801182886",
            "1181801182886",
            "4481704480121",
            "4481704480121",
            "1181801188351",
            "1181801188351",
            "952797001",
            "952797001",
            "1621701621207",
            "1621701621207",
            "1031701035098",
            "1591701591910",
            "1591701591343",
            "1591701591343",
            "8500026875001",
            "8500026875001",
            "1391801391222",
            "1391801391222",
            "193971887401",
            "193971887401",
            "195031143281",
            "195031143281",
            "1391801391211",
            "1391801391211",
            "8500051811715",
            "8500051811715",
            "1391801391201",
            "1391801391201",
            "1391801391223",
            "1391801391223",
            "8500051814739",
            "8500051814739",
            "9009652041332",
            "9009652041332",
            "887042356254",
            "887042722523",
            "30415390015",
            "2201702200569",
            "2201702200569",
            "8500019850001",
            "192643355361",
            "8500017744001",
            "1991701994157",
            "1991701994157",
            "1181801186499",
            "1181801186499",
            "193971357416",
            "193971357416",
            "30515000857",
            "30515000857",
            "8500048746542",
            "195031188329",
            "195031188329",
            "195031080562",
            "195031080562",
            "193971893204",
            "193971893204",
            "8500033402614",
            "8500033402614",
            "8500049477438",
            "8500049477438",
            "193971670935",
            "193971670935",
            "193971896168",
            "193971896168",
            "193971885759",
            "193971885759",
            "1391801391203",
            "1391801391203",
            "8500063735986",
            "8500065519275",
            "8500065519275",
            "1281701282032",
            "1281701282032",
            "9009655126623",
            "9009655126623",
            "193971795478",
            "193971795478",
            "2271702273447",
            "2271702273447",
            "1981701981105",
            "1981701981105",
            "8500048745917",
            "193971504193",
            "8500449313645",
            "8500449313645",
            "1961701960556",
            "1961701960556",
            "1991701994084",
            "1991701994084",
            "1991701994043",
            "1991701994043",
            "2201802200369",
            "637865445419",
            "637865445419",
            "8500062058345",
            "4481704480047",
            "4481704480047",
            "5700302180459",
            "5700302180459",
            "5700302429398",
            "5700302429398",
            "4481704480057",
            "4481704480044",
            "4481704480044",
            "4481704480051",
            "5700302279702",
            "719220532122",
            "719220532139",
            "1071701073459",
            "1071701073459",
            "719220532207",
            "8500016293002",
            "8500016293003",
            "2471702472253",
            "2471702472253",
            "2431702430217",
            "2431702430218",
            "2471702472255",
            "2471702472255",
            "2111702110239",
            "2111702110239",
            "1071701073460",
            "1071701073460",
            "2271702271688",
            "2271702271688",
            "2111802111765",
            "2111802111765",
            "2431702432564",
            "2431702432564",
            "3511703510022",
            "1071701073546",
            "1071701073546",
            "2271702273305",
            "2271702273305",
            "3003112960079",
            "3003112960079",
            "192643649750",
            "192643649750",
            "3003109738079",
            "3003109738079",
            "2041702040423",
            "2041702040423",
            "3003113273079",
            "3003113273079",
            "3511703510025",
            "1071701073587",
            "1071701073587",
            "1071701073577",
            "1071701073577",
            "1621701625158",
            "1621701625158",
            "2111802111204",
            "2111802111204",
            "3271703272986",
            "3700000510604",
            "1071701073586",
            "1071701073586",
            "1621701625157",
            "3271703272989",
            "1641801642083",
            "1641801642083",
            "1071701073588",
            "1071701073588",
            "1071701073589",
            "1071701073589");


    public static void main(String[] args) throws InterruptedException {
        List<List<String>> groupLists = ListUtil.stockListGroup(list);
        AtomicInteger sum = new AtomicInteger(0);
        List<CompletableFuture<Map<String, String>>> futureList = new ArrayList<>();
        groupLists.stream().forEach(listSkuNo -> {
            sum.getAndIncrement();
            CompletableFuture<Map<String, String>> mapCompletableFuture
                    = CompletableFuture.supplyAsync(() -> listSkuNo.stream().collect(Collectors.toMap(s -> s, v -> v, (v1, v2) -> v1)), Executors.newFixedThreadPool(5));
            futureList.add(mapCompletableFuture);
        });
        System.out.println("原始 list: " + list.size());
        System.out.println("分组 groupLists: " + groupLists.size());
        System.out.println("groupSum: " + sum.get());

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[groupLists.size()])).join();
        Map<String, String> map = new HashMap<>();
        futureList.forEach(fut -> {
            try {
                map.putAll(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        });
        System.out.println(map.entrySet());

        System.out.println("=======================================");


        List<List<String>> groupLists2 = ListUtil.stockListGroup(list);
        Map<String, String> map2 = new ConcurrentHashMap<>();
        groupLists2.stream().forEach(listSkuNo -> {
            CompletableFuture.supplyAsync(() -> {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("sleep 1000");
////                    Thread.sleep(1000);
////                    System.out.println("sleep 2000");
////                    Thread.sleep(1000);
////                    System.out.println("sleep 3000");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                return listSkuNo.stream().collect(Collectors.toMap(s -> s, v -> v, (v1, v2) -> v1));
            }, Executors.newFixedThreadPool(5))
                    .thenAccept(skuStockMap -> map2.putAll(skuStockMap));
        });
        System.out.println(map2.entrySet());

        System.out.println("=======================================");

        AtomicInteger index = new AtomicInteger(0);
        List<CompletableFuture<Map<String, String>>> futureList3 = new ArrayList<>();
        groupLists.stream().forEach(listSkuNo -> {
            CompletableFuture<Map<String, String>> mapCompletableFuture
                    = CompletableFuture.supplyAsync(() -> {
                index.getAndIncrement();
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("sleep 1000");
////                    Thread.sleep(1000);
////                    System.out.println("sleep 2000");
////                    Thread.sleep(1000);
////                    System.out.println("sleep 3000");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (index.get() == 4) {
                    System.out.println(index.get());
                    int res = index.get() / 0;
                }
                return listSkuNo.stream().collect(Collectors.toMap(s -> s, v -> v, (v1, v2) -> v1));
                        }, Executors.newFixedThreadPool(5));
            futureList3.add(mapCompletableFuture);
        });
        System.out.println("分组 groupLists3: " + groupLists.size());
        System.out.println("分组 groupLists3: " + groupLists.size());
        CompletableFuture.allOf(futureList3.toArray(new CompletableFuture[groupLists.size()])).join();
        Map<String, String> map3 = new HashMap<>();
        futureList3.forEach(fut -> {
            fut.thenAccept(fmap -> map3.putAll(fmap));
//            try {
//                map3.putAll(fut.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
        });
        System.out.println(map3.entrySet()); }
}
