# Compareable Vs Comparator


## Comparable Interface:

1. The Comparable interface is implemented by a class whose objects need to be sorted.

2. It contains a single method, compareTo(Object obj), which compares the current object with the specified object.

3. The compareTo method returns a negative integer, zero, or a positive integer if the current object is less than, equal to, or greater than the specified object, respectively.

4. By implementing Comparable, the class defines a natural ordering for its objects. For example, String and Integer classes implement Comparable to define a natural ordering based on their inherent properties.

## Comparator

1. The Comparator interface is used to define custom comparison logic separately from the target class.

2. It is often used when the target class does not have a natural ordering or when you want to sort objects based on different criteria at different times.

3. The Comparator interface contains a single method, compare(Object o1, Object o2), which compares two objects.
Unlike Comparable, Comparator is independent of the target class and can be implemented in a separate class. It allows for more flexible sorting strategies.

4. Java provides utility methods in the Collections class to sort collections using a Comparator.



## Example Code

In the example :

Student class implements Comparable to provide natural ordering based on age.

StudentNameComparator class implements Comparator to define custom ordering based on name.
We use Collections.sort() to sort the list of Student objects using both natural ordering (Comparable) and custom ordering (Comparator).

```java
import java.util.*;

class Student implements Comparable<Student>, Comparator<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Implementing Comparable interface for natural ordering based on age
    @Override
    public int compareTo(Student anotherStudent) {
        return this.age - anotherStudent.age;
    }

    // Implementing Comparator interface for custom ordering based on name
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20));
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 18));

        // Sorting by natural ordering (age)
        Collections.sort(students);
        System.out.println("Sorting by age:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }

        // Sorting by custom ordering (name)
        Collections.sort(students, new Student());
        System.out.println("\nSorting by name:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }
    }
}


```

Output

```java

Sorting by age:
Bob - 18
John - 20
Alice - 22

Sorting by name:
Alice - 22
Bob - 18
John - 20


```
## Important note

This method compares two Student objects based on their names. When you implement Comparator<Student>, you're saying that instances of Student can be compared to each other using this method.

In your main method, you are calling Collections.sort(students, new Student()), which might seem a bit confusing. This is because Student is both implementing Comparable<Student> and Comparator<Student>. The Collections.sort method can take either a Comparator instance or utilize the natural ordering defined by the Comparable interface.

In the Collections.sort(students, new Student()) call, you're providing an instance of Student as the comparator. When you do this, Java infers that you want to use the compare method implemented within the Student class itself. This is allowed because Student implements Comparator<Student>. So, the Collections.sort method will call the compare method defined within the Student class to perform the sorting based on the custom ordering (i.e., based on student names).

This is a convenient way to define both natural and custom ordering for a class in Java, allowing you to use the same class for both types of comparisons. However, it's important to note that in practice, it's more common to implement Comparator in a separate class when you want to define custom ordering, rather than implementing it directly in the class being sorted.

``` java

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student anotherStudent) {
        return this.age - anotherStudent.age; // natural ordering based on age
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName()); // custom ordering based on name
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20));
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 18));

        // Sorting using Comparable (natural ordering based on age)
        Collections.sort(students);
        System.out.println("Sorting by age:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }

        // Sorting using Comparator (custom ordering based on name)
        Collections.sort(students, new StudentNameComparator());
        System.out.println("\nSorting by name:");
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getAge());
        }
    }
}

```