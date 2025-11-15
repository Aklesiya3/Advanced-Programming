import java.util.*;

public class Vector1 {
    public static void main(String args[]) {
        // Create a Vector of Strings
        Vector<String> v = new Vector<String>();

        // Add elements to the Vector
        v.add("SoEEC");
        v.add("SoMMCE");
        v.add("SoCEA");
        v.add("SoANC");

        // Create an Iterator to traverse the Vector
        Iterator<String> itr = v.iterator();

        // Print elements using the Iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
