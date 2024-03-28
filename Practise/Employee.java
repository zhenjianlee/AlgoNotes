package Practise;

import java.util.Comparator;

public class Employee implements Comparable<Employee> , Comparator<Employee> {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Employee(String firstName, String lastName, int age, double salary){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.salary=salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", salary="
                + salary + "]";
    }

    @Override
    public int compareTo(Employee other){
        return this.lastName.compareTo(other.getLastName());

    }
    
    @Override 
    public int compare(Employee a, Employee b){
        return a.age - b.age;
    }


}
