import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        System.out.println(c.getClass().getName());
        for (int i = 1; i <= 10; i++) {
            c.add(i + " * " + i + " = " + i * i);
        }
        Iterator<String> iter = c.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

