import java.util.*;

class TreeMap1 {
    public static void main(String args[]) {
        // Creating a TreeMap
        TreeMap<Integer, String> map = new TreeMap<>();

        // Adding key-value pairs
        map.put(1, "CSE");
        map.put(2, "SE");
        map.put(3, "EPCE");
        map.put(4, "ECE");

        // Traversing the map
        for (Map.Entry<Integer, String> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
