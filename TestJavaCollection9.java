import java.util.*;

public class TestJavaCollection9 {
    public static void main(String args[]) {
        // Creating a TreeSet and adding elements
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(4);

        // Using Iterator to traverse the TreeSet
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
