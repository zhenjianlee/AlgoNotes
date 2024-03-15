package Practise;

import java.util.ArrayList;
import java.util.Arrays;

public class PractiseMergeSortArrayList {

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        Integer range = 10000;
        Integer len = 21;
        for (int i=0; i<len;i++){
            Integer random = (int)(Math.random()*range);
            list.add(random);
        }

        Integer[] array = list.toArray(new Integer[list.size()]);
        print(array);
        print(list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array));
        print(list2);

        System.out.println("Starting mergeSort !!!!");
        mergeSort(list2);
        print(list2);
    }

    private static void print(Integer[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    private static void print(ArrayList<Integer> arr){
        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+ " ");
        }
        System.out.println();
    }

    private static void mergeSort(ArrayList<Integer> list){
        //mergeSort using ArrayList!
        if (list.size()<2)return;

        int mid = list.size()/2;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i=0;i<mid;i++){
            left.add(list.get(i));
        }

        for (int j=mid;j<list.size();j++){
            right.add(list.get(j));
        }

        mergeSort(left);
        mergeSort(right);
        merge(list,left,right);

    }

    private static void merge(ArrayList<Integer>list, ArrayList<Integer> left, ArrayList<Integer>right){
        int i=0,j=0,k=0;

        while (i<left.size() && j<right.size()){
            if (left.get(i)<= right.get(j)){
                list.set(k , left.get(i));
                k++;
                i++;
            }else{
                list.set(k,right.get(j));
                k++;
                j++;
            }
        }

        while (i < left.size()){
            list.set(k,left.get(i));
            k++;
            i++;
        }

        while (j < right.size()){
            list.set(k,right.get(j));
            k++;
            j++;
        }
    }

}
