package Practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class PractiseSortClass {
    public static void main(String[] args){

        Employee jian = new Employee("Zhen Jian", "Lee", 36, 5000.00);
        Employee tho = new Employee("Tho", "Nguyen", 36, 20000.00);
        Employee kyle = new Employee("Kyle", "Nguyen", 29, 8000.00);
        Employee pig = new Employee("Emilia", "Lee", 6, 500.00);
        Employee robotman = new Employee("Xiaomi", "Xi", 5, 20.00);
        Employee dishwasher = new Employee("Washer", "Bosch", 1, 15.00);
        Employee washingMachine = new Employee("Lifes", "Good", 7, 30.00);

        Employee[] array = new Employee[]{jian,tho, kyle, pig,robotman,dishwasher,washingMachine};
        //mergeSort by Salary
        sortbySalary(array);
        printArray(array, "mergesort -salary");

        //sorting by Comparable Interface -lastname
        Arrays.sort(array);
        printArray(array, "comparable - lastname");

        //sorting by Comparator Interface - age
        Arrays.sort(array, jian);
        printArray(array , "comparable - age");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Mike", "Myers", 3.55 , 40));
        studentList.add(new Student("Taylor","Swift",5.00,34));
        studentList.add(new Student ("Jay","Chou",3.45,45));
        studentList.add(new Student ("Lady", "Gaga",4.00,36));
        studentList.add(new Student("Sam","Altman",5.00,37));
        studentList.add(new Student("Barrack","Obama",4.58,49));
        studentList.add(new Student("Taylor","Lautner",2.12,32));


        Collections.sort(studentList, new Student(null, null, 0, 0));
        printArray(studentList, "comparator - firstName then lastName");
    }

    private static void sortbySalary(Employee[] a){
        if (a.length <2) return;
        int mid = a.length/2;
        Employee[] left = new Employee[mid];
        Employee[] right = new Employee[a.length-mid];

        for (int i=0; i<mid; i++){
            left[i]=a[i];
        }

        for (int j=mid;j<a.length;j++){
            right[j-mid]= a[j];
        }
        sortbySalary(left);
        sortbySalary(right);
        mergebySalary(a,left,right);
    }

    private static void mergebySalary(Employee[]a, Employee[] l, Employee[] r){
        int i=0, j=0, k=0;

        while (i<l.length && j <r.length){
            if (l[i].getSalary()<= r[j].getSalary()){
                a[k++]=l[i++];
            }else {
                a[k++]=r[j++];
            }
        }

        while (i < l.length){
            a[k++]= l[i++];
        }

        while (j <r.length){
            a[k++]=r[j++];
        }
    }

    private static void printArray(Employee[] a, String note){
        System.out.println("----Start------ Sort by " + note +"-------");
        for (int i=0; i<a.length; i++){
            System.out.println(a[i].toString());
        }
        System.out.println("----End------");
    }

    private static void printArray(ArrayList<Student> a, String note){
        System.out.println("----Start------ Sort by " + note +"-------");
        for (int i=0; i<a.size(); i++){
            System.out.println(a.get(i).toString());
        }
        System.out.println("----End------");
    }


}


