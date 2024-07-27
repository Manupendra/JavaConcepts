package map;

import java.util.*;

public class HashMapConcepts {
    public static void main(String[] args) {

        Map<Integer, String> rollNoToNameMap = new HashMap<>();
        rollNoToNameMap.put(null,"Test");
        rollNoToNameMap.put(0,null);
        rollNoToNameMap.put(1,"Raj");
        rollNoToNameMap.put(2,"Ankush");

        // compute if Present
        rollNoToNameMap.putIfAbsent(null,"test");
        rollNoToNameMap.putIfAbsent(0,"Zero");

        for (Map.Entry<Integer,String> entryMap: rollNoToNameMap.entrySet()){
            Integer key = entryMap.getKey();
            String value = entryMap.getValue();
            System.out.println("Key: "+key+" Value: "+value);
        }

    }
}
