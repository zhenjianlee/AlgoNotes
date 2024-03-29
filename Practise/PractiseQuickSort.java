package Practise;

import java.util.*;

public class PractiseQuickSort {

    public static void main(String[] hello) {
        int[] nums = new int[] { 12, 84, 600, 2314, 7, 56, 450, 267, 8, 214 };

        quickSort(nums, 0, nums.length - 1);
        printArray(nums, "Jian Quicksort");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Mike", "Myers", 3.55, 40));
        studentList.add(new Student("Taylor", "Swift", 5.00, 34));
        studentList.add(new Student("Jay", "Chou", 3.45, 45));
        studentList.add(new Student("Lady", "Gaga", 4.00, 36));
        studentList.add(new Student("Sam", "Altman", 5.00, 37));
        studentList.add(new Student("Barrack", "Obama", 4.58, 49));
        studentList.add(new Student("Taylor", "Lautner", 2.12, 32));

        String type = "age";
        quickSort(studentList, 0, studentList.size() - 1, type);
        printArray(studentList, type);

        type = "gpa";
        quickSort(studentList, 0, studentList.size() - 1, type);
        printArray(studentList, type);

        Collections.sort(studentList, new Student(type, type, 0, 0));
        printArray(studentList, "Comparable sorting by firstname lastname");

        Collections.sort(studentList, (a, b) -> a.getAge() - b.getAge());
        printArray(studentList, "Lambda function sorting by age type int");

        // see Note A below - Important!
        Collections.sort(studentList, (a, b) -> Double.compare(a.getGpa(), b.getGpa()));
        printArray(studentList, "Lambda function sorting by gpa type double");

    }

    private static void quickSort(ArrayList<Student> list, int start, int end, String type) {

        if (start > end)
            return;

        int pivot = partition(list, start, end, type);

        quickSort(list, start, pivot - 1, type);
        quickSort(list, pivot + 1, end, type);
    }

    private static int partition(ArrayList<Student> list, int start, int end, String type) {

        int i = start - 1;

        if (type.equals("gpa")) {
            double pivot = list.get(end).getGpa();
            for (int j = start; j < end; j++) {
                if (list.get(j).getGpa() < pivot) {
                    i++;
                    swap(list, i, j);
                }
            }
            i++;
            swap(list, i, end);

        } else if (type.equals("age")) {
            int pivot = list.get(end).getAge();
            for (int j = start; j < end; j++) {
                if (list.get(j).getAge() < pivot) {
                    i++;
                    swap(list, i, j);
                }
            }
            i++;
            swap(list, i, end);

        }

        return i;

    }

    private static void swap(ArrayList<Student> list, int a, int b) {
        Student temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end < start)
            return;

        int pivot = partition(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printArray(int[] a, String message) {
        System.out.println("-----Start ---- " + message + " ----- ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n-----End ---- " + message + " ----- ");
    }

    private static void printArray(ArrayList<Student> a, String message) {
        System.out.println("-----Start ---- " + message + " ----- ");
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        System.out.println("-----End ---- " + message + " ----- ");
    }
}

/*
 * NOTE A
 * 
 * You cannot directly subtract the GPAs (a.getGpa() - b.getGpa()) in a lambda
 * expression for sorting because the Collections.sort() method expects a
 * comparator that returns an integer value, indicating the order of elements.
 * 
 * Using (a.getGpa() - b.getGpa()) would result in a double value, which is
 * incompatible with the expected return type of the comparator.
 * 
 * Instead, you should use Double.compare() method as shown in the previous
 * example. This method properly compares two double values and returns an
 * integer value indicating their relative order.
 * 
 * 
 */