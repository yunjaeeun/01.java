package com.ohgiraffers.section03.run;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        Map hmap = new HashMap<>();
        hmap.put("one", new Date());
        hmap.put(12, "red apple");
        hmap.put(33, 124);

        System.out.println("키가 \"one\"인 value 값: " + hmap.get("one"));
        System.out.println("Map의 toString(): " + hmap);

        /* 설명. 키 값은 중복되면 이후 put 되는 키와 밸류가 덮어씌운다.(주의할것) */
        hmap.put(12, "purple banana");
        System.out.println(hmap.get(12));

        hmap.put(77, "purple banana");
        System.out.println(hmap);

        System.out.println("Map이 지닌 entry의 수: " + hmap.size());

        System.out.println("77번 키와 관련된 entry 삭제: " + hmap.remove(77));
        System.out.println("삭제 후 entry의 수: " + hmap.size());

        /* 필기. Map을 반복하여 각 entry들(키와 밸류)을 활용해 보자. */
        HashMap<String, String> hmap2 = new HashMap<>();
        hmap2.put("one", "java 17");
        hmap2.put("two", "mariaDB 10");
        hmap2.put("three", "servlet/jsp");
        hmap2.put("four", "springboot 3.0");
        hmap2.put("five", "vue.js");
        /* 목차. 1. keySet()을 활용한 interator 활용하기 */
        Set<String> keys = hmap2.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            System.out.println("key값: " + keys + ", value값: " + hmap2.get(key));
        }

        /* 목차. 2. entrySet()을 활용한 interator 활용하기 */
        Set<Map.Entry<String,String>> set = hmap2.entrySet();
        Iterator<Map.Entry<String, String>> iterEntry = set.iterator();
        while (iterEntry.hasNext()) {
            Map.Entry<String, String> entry = iterEntry.next();
            System.out.println("키값: " + entry.getKey() + ", value값: " + entry.getValue());
        }
    }
}
