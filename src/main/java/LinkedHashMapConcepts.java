import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapConcepts {
    public static void main(String[] args) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Raj");
        map.put(21, "Ankush");
        map.put(31, "Vibhor");
        map.put(41, "Etinne");
        map.put(51, "E");

        System.out.println("---------------------LinkedHashMap------------------");
        map.forEach((Integer key, String val) -> System.out.println(key + ":" + val));

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Raj");
        map1.put(21, "Ankush");
        map1.put(31, "Vibhor");
        map1.put(41, "Etinne");
        map1.put(51, "E");

        System.out.println("---------------------HashMap------------------");
        map1.forEach((Integer key, String val) -> System.out.println(key + ":" + val));

        Map<Integer, String> map3 = new LinkedHashMap<>(16,.75F,true);
        map3.put(1, "Raj");
        map3.put(21, "Ankush");
        map3.put(31, "Vibhor");
        map3.put(41, "Etinne");
        map3.put(51, "E");

        System.out.println("---------------------LinkedHashMap with ACCESS ORDER -> LOW TO HIGH------------------");

        // accessing some data
        map3.get(31);
        map3.forEach((Integer key, String val) -> System.out.println(key + ":" + val));

    }
}
