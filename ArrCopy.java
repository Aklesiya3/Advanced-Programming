import java.util.*;
public class ArrCopy {

public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();
        a.add("henok");
        a.add("dudu");
        a.add("bemni");

    Iterator<String> itr = a.iterator();
    while (itr.hasNext()) {
        b.add(itr.next());
    } 

    System.out.println("After copying the list");
    Iterator<String> itr2 = b.iterator();
    while (itr2.hasNext()) {
        System.out.println(itr2.next());
    }

    
    Collections.reverse(b);
    System.out.println("After reversing the list");
    Iterator<String> itr3 = b.iterator();
    while (itr3.hasNext()) {
        System.out.println(itr3.next());
    }

}
}
 
