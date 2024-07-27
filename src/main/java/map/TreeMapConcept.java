package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapConcept {
    public static void main(String[] args) {

        Map<Integer, String> treeMap1 = new TreeMap<>((Integer key1, Integer key2) -> key2 - key1);
        treeMap1.put(21, "SJ");
        treeMap1.put(11,"PJ");
        treeMap1.put(13,"KJ");
        treeMap1.put(5,"TJ");
        // decreasing order
        treeMap1.forEach((Integer key, String value) -> System.out.println(key+":"+value));

        System.out.println("------------------------------------");

        Map<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.put(21, "SJ");
        treeMap2.put(11,"PJ");
        treeMap2.put(13,"KJ");
        treeMap2.put(5,"TJ");
        // decreasing order
        treeMap2.forEach((Integer key, String value) -> System.out.println(key+":"+value));


    }
}
