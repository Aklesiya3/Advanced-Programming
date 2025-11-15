import java.util.*;

class HashSetDemo {
    public static void main(String args[]) {
        // Creating a HashSet and adding elements
        HashSet<String> set = new HashSet<>();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        // Using Iterator to traverse the HashSet
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
