import java.util.*;

class ArrayListDemo {
    public static void main(String[] args) {
        // Create an ArrayList to store Strings
        ArrayList<String> al = new ArrayList<String>();

        // Adding elements to the ArrayList
        al.add("Sheger");
        al.add("Adama");
        al.add("Hawassa");
        al.add("BahirDar");
        al.add("Mekele");
        al.add(1, "DireDawa"); // Insert at index 1
        al.add(2, "Asosa");    // Insert at index 2

        // Print size of ArrayList
        System.out.println("Size of the ArrayList is: " + al.size());

        // Retrieve elements using Iterator
        System.out.println("Retrieving elements in ArrayList using Iterator:");
        Iterator<String> it = al.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "\t");
        }
    }
}
