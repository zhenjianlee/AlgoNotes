package Practise;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String firstName;
    private String lastName;
    private double gpa;
    private int age;

    public Student (String firstName, String lastName, double gpa, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.age = age;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Student a, Student b){

        if (a.getFirstName().equals(b.getFirstName())){
            return a.getLastName().compareTo(b.getLastName());
        }

        return a.getFirstName().compareTo(b.getFirstName());
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gpa=" + gpa + ", age=" + age + "]";
    }
}
