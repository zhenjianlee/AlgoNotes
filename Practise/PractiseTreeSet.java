package Practise;

import java.util.*;

public class PractiseTreeSet {

    /*
     * In order to use a lambda function as a comparator for sorting purposes in a
     * TreeSet, the Employee class does not necessarily need to implement the
     * Comparator or Comparable interface explicitly. However, if you want to use
     * lambda expressions directly in the constructor of TreeSet, it's required that
     * the class you're working with (Employee in this case) either implements the
     * Comparable interface or you provide a comparator.
     * 
     * Here's a brief explanation of the two approaches:
     * 
     * Implementing Comparable:
     * If the Employee class implements the Comparable interface, it must provide a
     * compareTo method, which defines the natural ordering of instances of the
     * class. In this case, you can create a TreeSet without providing a comparator,
     * and it will use the natural ordering defined by the compareTo method.
     * 
     * Providing a Comparator:
     * If the Employee class does not implement Comparable, or if you want to use a
     * different ordering than the natural ordering defined by compareTo, you can
     * provide a comparator explicitly when creating the TreeSet. This comparator
     * can be provided as a separate class that implements the Comparator interface,
     * or you can use a lambda expression directly as you've shown in your code
     * snippet.
     * 
     * In the lambda expression provided in your code snippet, you're directly
     * providing a comparator to the TreeSet constructor. In this case, the Employee
     * class doesn't need to implement Comparable, but you do need to ensure that
     * the lambda expression correctly implements the comparison logic for Employee
     * objects.
     */

    public static void main(String[] iCanWriteAnyThingHere) {

        TreeSet<Employee> employeeSet = new TreeSet<>((a, b) -> Double.compare(a.getSalary(), b.getSalary()));

        employeeSet.add(new Employee("Zhen Jian", "Lee", 36, 5000.00));
        employeeSet.add(new Employee("Tho", "Nguyen", 36, 20000.00));
        employeeSet.add(new Employee("Kyle", "Nguyen", 29, 8000.00));
        employeeSet.add(new Employee("Emilia", "Lee", 6, 500.00));
        employeeSet.add(new Employee("Xiaomi", "Xi", 5, 20.00));
        employeeSet.add(new Employee("Washer", "Bosch", 1, 15.00));
        employeeSet.add(new Employee("Lifes", "Good", 7, 30.00));

        printSet(employeeSet, "sort by salary type double comparator");

        TreeSet<Employee> employeeSet2 = new TreeSet<>(
                (a, b) -> {
                    if (a.getLastName().equals(b.getLastName())) {
                        return a.getFirstName().compareTo(b.getFirstName());
                    }

                    return a.getLastName().compareTo(b.getLastName());
                }

        );

        employeeSet2.add(new Employee("Zhen Jian", "Lee", 36, 5000.00));
        employeeSet2.add(new Employee("Tho", "Nguyen", 36, 20000.00));
        employeeSet2.add(new Employee("Kyle", "Nguyen", 29, 8000.00));
        employeeSet2.add(new Employee("Emilia", "Lee", 6, 500.00));
        employeeSet2.add(new Employee("Xiaomi", "Xi", 5, 20.00));
        employeeSet2.add(new Employee("Washer", "Bosch", 1, 15.00));
        employeeSet2.add(new Employee("Lifes", "Good", 7, 30.00));

        printSet(employeeSet2, "sort by lastname type string comparator");

        employeeSet2.remove(new Employee("Lifes", "Good", 7, 30.00) );

        printSet(employeeSet2, "removed Lifes Good from employeeset2");
    }

    private static void printSet(TreeSet<Employee> set, String note) {
        System.out.println("----------Start -------------" + note + "--------");
        for (Employee e : set) {
            System.out.println(e);
        }
        System.out.println("----------End -------------" + note + "--------\n");
    }
}
