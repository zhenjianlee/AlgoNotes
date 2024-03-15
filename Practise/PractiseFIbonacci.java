package Practise;

import java.util.ArrayList;

public class PractiseFIbonacci {

    public static void main(String[] args){

        // 0 1 2 3 4 5 6 7  8  9
        // 0 1 1 2 3 5 8 13 21 34

        fibonacciNaive(10);
        fibonacciDigitalOcean(10);
        System.out.println(fibonacciRecursion(10));
    }


    private static void fibonacciNaive(int target){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        if (target >2){
            for (int i=2;i<=target;i++){
                int curr = list.get(list.size()-1)+list.get(list.size()-2);
                list.add(curr);
            }
        }

        for (int k=0; k<list.size();k++){
            System.out.print(list.get(k)+ " ");
        }
        System.out.println();
    }

    private static void fibonacciDigitalOcean(int target){

        int a =0;
        int b =1;
        int c =1;

        for (int i=0; i<= target ; i ++){
            System.out.print(a + " ");
            a = b;
            b= c;
            c= a +b;
        }
        System.out.println();

    }

    private static int fibonacciRecursion(int target){
        if (target == 1 || target ==0)return target;

        return fibonacciRecursion(target-1) + fibonacciRecursion(target-2);
    }
}
