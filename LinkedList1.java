import java.util.*;  

public class LinkedList1 {  
    public static void main(String args[]) {  
        // Create a LinkedList of Strings
        LinkedList<String> pl = new LinkedList<String>();  

        // Add elements to the LinkedList
        pl.add("Java");  
        pl.add("Python");  
        pl.add("C++");  
        pl.add("C#");  

        // Use Iterator to traverse the LinkedList
        Iterator<String> itr = pl.iterator();  // Corrected: was 'al' → should be 'pl'

        while (itr.hasNext()) {  
            System.out.println(itr.next());  
        }  
    }  
}
