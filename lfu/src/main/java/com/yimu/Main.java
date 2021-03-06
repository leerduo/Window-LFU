package com.yimu;
import java.lang.System;
import java.util.Map;
import java.util.Queue;

public class Main{

    public static void main(String args[]){

        WindowLFU<String, Integer> cache = new WindowLFU<>(3, 9);
      /*  cache.put("green", 4);
        cache.put("blue", 1);
        cache.put("blue", 3);
        cache.put("red", 5);
        cache.put("yellow", 2);
        cache.put("orange", 1);
        cache.put("orange", 1);
        cache.put("yellow", 2);
        cache.put("yellow", 2);*/


        cache.put("green", 4);
        cache.put("green", 1);
        cache.put("blue", 3);
        cache.put("red", 5);
        cache.put("green", 2);
        cache.put("blue", 1);
        cache.put("red", 1);
        cache.put("orange", 2);
        cache.put("yellow", 2);
//        cache.put("blue", 2);
//        System.out.println("Shoot:" + cache.hitrate());

        Map<String, WindowLFU<String,Integer>.CacheNode<Integer>> data = cache.getCache();
        for(Map.Entry<String, WindowLFU<String,Integer>.CacheNode<Integer>> entry : data.entrySet()){
            System.out.println(entry.getKey() + ": "+entry.getValue().counts);
        }

        Queue<String> windows = cache.getWindow();
        for(String str : windows){
            System.out.print(str+",");
        }
    }
}