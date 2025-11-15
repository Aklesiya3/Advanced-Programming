import java.util.*;

public class TestJavaCollection4 {
    public static void main(String args[]) {
        // Create a Stack of Strings
        Stack<String> stack = new Stack<String>();

        // Push elements onto the stack
        stack.push("SoEEC");
        stack.push("SoMMCE");
        stack.push("SoCEA");
        stack.push("SoANC");
        stack.push("SoHSS");

        // Pop the top element
        stack.pop(); // removes "SoHSS"

        // Create an Iterator to traverse the stack
        Iterator<String> itr = stack.iterator();

        // Print elements using Iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
