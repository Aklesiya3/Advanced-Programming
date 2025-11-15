import java.util.*;

public class LegVector1 {
    public static void main(String ar[]) {
        // Create a Vector of Strings
        Vector<String> vec = new Vector<String>();

        // Add elements using legacy method addElement()
        vec.addElement("B");
        vec.addElement("A");
        vec.addElement("T");
        vec.addElement("M");
        vec.addElement("A");
        vec.addElement("N");

        // Display the vector
        System.out.println("Vector = " + vec);

        // Display the size of the vector
        System.out.println("Size of Vector = " + vec.size());

        // Display first and last elements
        System.out.println("First element in Vector = " + vec.firstElement());
        System.out.println("Last element in Vector = " + vec.lastElement());

        // Access element at specific index
        System.out.println("Element at 2nd index = " + vec.elementAt(2));

        // Remove element at specific index
        vec.removeElementAt(2);
        System.out.println("After removing element at 2nd index, Vector = " + vec);
    }
}
