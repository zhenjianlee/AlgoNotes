package Practise;

import java.util.Arrays;
import java.util.Random;

public class PractiseSortingAgain {
    public static void main(String[] args) {
        int num = 100;
        Random random = new Random();
        int[] array = new int[num];
        for (int i=0 ; i< num ; i++){
            array[i]= random.nextInt(0,1000);
        }
        printArray(array,"Unsorted");
        quickSort(array,0,array.length-1);
        printArray(array,"Sorted!");
    }

    public static void printArray(int[] arr, String msg){
        System.out.println(msg +" "+Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start , int end){

        if (start>= end)return;
        int pivot = partition(arr, start, end);
        quickSort(arr,start, pivot-1);
        quickSort(arr,pivot+1,end);

    }

    private static int partition(int[] arr , int start, int end){

        int pivot = arr[end];
        int i=start-1;

        for(int j=start; j<end ; j++){
            if (arr[j]< pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i, end);
        return i;
    }

    private static void swap(int[] arr , int idxA , int idxB){
        int temp = arr[idxA];
        arr[idxA]=arr[idxB];
        arr[idxB]= temp;

    }




}
