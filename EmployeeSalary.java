import java.util.*;
import java.util.Map.Entry;

public class EmployeeSalary {
    public static void main(String[] args) {
        Map<String, Double> emp = new HashMap<>();

        emp.put("Alemu", 9000.0);
        emp.put("Bini", 8500.0);
        emp.put("Chaltu", 10000.0);
        emp.put("Dawit", 7500.0);
        emp.put("Eden", 9200.0);
        emp.put("Fikru", 11000.0);
        emp.put("Genet", 8900.0);
        emp.put("Hana", 9500.0);
        emp.put("Ibrahim", 8000.0);
        emp.put("Jonas", 9700.0);
        emp.put("Kebede", 8800.0);
        emp.put("Liya", 9400.0);
        emp.put("Mimi", 9100.0);
        emp.put("Nati", 7000.0);
        emp.put("Olana", 9900.0);
        emp.put("Peter", 8800.0);
        emp.put("Queen", 10100.0);
        emp.put("Robel", 8900.0);
        emp.put("Sara", 8600.0);
        emp.put("Tigist", 9800.0);

        double total = 0;
        for (double salary : emp.values()) {
            total += salary;
        }

        double min = Collections.min(emp.values());
        double max = Collections.max(emp.values());
        double avg = total / emp.size();

        System.out.println("Total Salary: " + total);
        System.out.println("Minimum Salary: " + min);
        System.out.println("Maximum Salary: " + max);
        System.out.println("Average Salary: " + avg);

        for (Entry<String, Double> e : emp.entrySet()) {
            if (e.getValue() == min)
                System.out.println("Employee with Minimum Salary: " + e.getKey());
            if (e.getValue() == max)
                System.out.println("Employee with Maximum Salary: " + e.getKey());
        }

        System.out.println("\nSorted Employee Details by Name:");
        emp.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
