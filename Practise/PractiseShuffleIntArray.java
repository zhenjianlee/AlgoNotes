package Practise;

import java.util.Random;

public class PractiseShuffleIntArray {

    public static void main(String[] args){
        int[] array = new int[]{25,36,88, 250,300,280,49,60};

        for (int i=0; i<15; i ++){
            shuffleArray(array);
            printArray(array);
        }
    }

    private static void shuffleArray(int[] a){
        Random random = new Random();
        for (int i=0; i<a.length;i++){
            int randIdx = random.nextInt(a.length);
            int temp = a[i];
            a[i]= a[randIdx];
            a[randIdx]=temp;
        }
    }

    private static void  printArray(int[] a){
        for (int i=0; i< a.length; i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

}