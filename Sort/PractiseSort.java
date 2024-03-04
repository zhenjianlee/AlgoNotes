package Sort;

import java.util.Arrays;

public class PractiseSort{

    public static void main(String[] args){
        int len = 100000;
        int range = 20000;
        int[] array1 = new int[len];
        for (int i=0; i<len;i++){
            int rando = (int)Math.random()*range;
            array1[i]=rando;
        }

        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array2, array2.length);
        int[] array4 = Arrays.copyOf(array2, array2.length);

        selectionSort(array1);
        insertionSort(array2);
        mergeSortMain(array3);
        librarySort(array4);

        boolean test = true;
        for (int i=0 ; i<array1.length;i++){
            if (array4[i] != array1[i]){
                test=false;
                System.out.println("Selection sort failed");
            }

            if (array4[i] != array2[i]){
                test=false;
                // System.out.println("Insertion sort failed");
            }

            if (array4[i] != array3[i]){
                test=false;
                System.out.println("Merge sort failed");
            }
        }

        if (test){
            System.out.println("All sorting passed!");
        }
    }

    private static void printArray(int[] a){
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static void selectionSort(int[]a){
        long start = System.nanoTime();
        for (int i=0; i<a.length; i++){
            int min= Integer.MAX_VALUE;
            int minIdx = 0;
            for (int j=i; j<a.length;j++){
                if (a[j]<= min){
                    min= a[j];
                    minIdx=j;
                }
                int temp = a[i];
                a[i]=a[minIdx];
                a[minIdx]=temp;
            }
        }
        long end = System.nanoTime();
        System.out.println("Selection sort! Time taken="+(end-start)+ " ns");
        //printArray(a);
    }

    private static void insertionSort(int[] a){
        long start = System.nanoTime();
        for (int i=1 ; i< a.length; i++){
            int key = a[i];
            int j= i-1;
            while (j>=0 && a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        long end = System.nanoTime();
        System.out.println("Insertion sort! Time taken="+(end-start)+ " ns");
        //printArray(a);
    }

    private static void mergeSortMain(int[] a){
        long start = System.nanoTime();
        mergeSort(a);
        long end = System.nanoTime();
        System.out.println("Merge Sort! Time taken="+(end-start)+ " ns");
        //printArray(a);
    }

    private static void mergeSort(int[] a){
        if (a.length<2)return;
        int mid= a.length/2;
        int[] left = new int[mid];
        int[] right = new int[a.length-mid];

        for (int i=0; i<mid; i++){
            left[i]=a[i];
        }

        for (int j=mid; j<a.length; j++){
            right[j-mid]=a[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(a,left,right);
    }

    private static void merge(int[] a ,int[] l, int[] r){
        int i=0, j=0, k=0;

        while (i<l.length && j < r.length){
            if (l[i]<= r[j]){
                a[k++]=l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i<l.length){
            a[k++]=l[i++];
        }

        while (j<r.length){
            a[k++] = r[j++];
        }
    }

    private static void librarySort(int[]a){
        long start = System.nanoTime();
        Arrays.sort(a);
        long end = System.nanoTime();
        System.out.println("Library Sort! Time taken="+(end-start) + " ns");
    }



}