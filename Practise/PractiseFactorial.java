package Practise;

public class PractiseFactorial {

    public static void main(String[] args){
        long num = 10;
        factorialNaive(num);
        System.out.println("Factorial (recursion) of "+ num + " equals to=" +factorialRecursion(num));
    }

    private static long factorialNaive(long num){
        long sum =num;
        long cur=num-1;
        while ( cur >0){
            sum *=cur;
            cur--;
        }
        System.out.println("Factorial (naive) of "+num+" equals to ="+ sum);
        return sum;
    }

    private static long factorialRecursion(long num){
        if (num ==1) return 1;
        return num*factorialRecursion(num-1);
    }

}
